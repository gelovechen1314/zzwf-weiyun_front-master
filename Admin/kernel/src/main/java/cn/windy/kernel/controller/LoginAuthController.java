package cn.windy.kernel.controller;

import cn.windy.kernel.KernelConstants;
import cn.windy.kernel.UserConfig;
import cn.windy.kernel.model.Menu;
import cn.windy.kernel.model.Role;
import cn.windy.kernel.model.User;
import cn.windy.kernel.repository.MenuRepository;
import cn.windy.kernel.repository.RoleRepository;
import cn.windy.kernel.repository.UserRepository;
import cn.windy.kernel.service.IUserService;
import cn.windy.kernel.vo.AuthResult;
import cn.windy.kernel.vo.Result;
import cn.windy.redis.JedisUtil;
import cn.windy.util.encrypt.MD5;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户登录及用户登录后校验
 */
@RestController
@RequestMapping("/kernel")
public class LoginAuthController extends BaseController {

    private Logger log = LoggerFactory.getLogger(LoginAuthController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    IUserService userService;

    /**
     * 用户登录
     * @param authUser
     * @return
     */
    @RequestMapping("/auth")
    public AuthResult auth(User authUser){
        AuthResult result = new AuthResult();
        List<User> list;
        if(StringUtils.isNumber(authUser.getAccount())){ //使用手机号登录
            list = userRepository.findByPhone(authUser.getAccount());
        }else{ //使用账号登录
            list = userRepository.findByAccount(authUser.getAccount());
        }

        if(list == null || list.size()==0){
            result.setCode("0-1001");
            result.setMessage("登录时账号错误");
        }else{
            User user = list.get(0);
            if(user.getPwdEncrypt().equals("1")&&user.getPassword().equals(MD5.encode(authUser.getPassword()))  //加密验证
                    || user.getPwdEncrypt().equals("0") && user.getPassword().equals(authUser.getPassword())){ //非加密验证
                result.setCode("200");
                result.setMessage("登录成功");
                String authToken = UUID.randomUUID().toString();
                result.setToken(authToken);
                result.setId(user.getId());
                result.setAccount(user.getAccount());
                result.setName(user.getName());
                //添加缓存并设置超时时间
                JedisUtil.set(authToken, JSON.toJSONString(user), KernelConstants.SESSION_TIMEOUT);
                //添加默认用户配置信息到redis
                UserConfig config = new UserConfig();
                config.setUser(user);
                JedisUtil.set("UserConfig:"+user.getPhone(),JSON.toJSONString(config));

                //加载用户菜单（权限） 步骤1、获取角色(每人只有一个角色)  2、获取菜单
                List<Role> roleList = roleRepository.findByUserId(user.getId());
                StringBuilder menuStr = new StringBuilder();
                if(roleList == null || roleList.size() == 0){
                    //因为没有角色所以权限为空
                }else{
                    Role role = roleList.get(0);
                    String menuStrCache = JedisUtil.get("RoleMenu_"+role.getCode());
                    if(menuStrCache == null){ //缓存中不存在，需要去查询数据库
                        List<Menu> menuList = menuRepository.findByRoleId(role.getId(),0L);
                        for (Menu menu : menuList) {
                            menuStr.append(loadPermission(role.getId(),menu));
                        }
                        if(!devModel) //不是开发模式，才设置缓存
                            JedisUtil.set("RoleMenu_"+role.getCode(),menuStr.toString());
                    }else{
                        menuStr.append(menuStrCache);
                    }
                }

                result.setPermission(menuStr.toString());
            }else{
                //密码错误
                result.setCode("0-1002");
                result.setMessage("登录时密码错误");
            }
        }
        return result;
    }

    @RequestMapping("/token")
    public Result token(@RequestBody Map<String,String> map){
        Result result = new Result();
        String token = map.get("token");
        String sessionJson = JedisUtil.get(token);
        if(sessionJson==null || "".equals(sessionJson)){
            log.info("当前用户切换菜单，检测用户登陆超时，返回重新登陆......");
            result.setCode("0-0000");
            result.setMessage("登录超时");
        }else{
            log.info("当前用户切换菜单，引发session刷新为30分钟......");
            result.setCode("200");
            //更新token的超时时间
            JedisUtil.expire(token,KernelConstants.SESSION_TIMEOUT);
        }
        return result;
    }

    @RequestMapping("/changePassword")
    public Result changePassword(@RequestBody User user){
        Result result = new Result();
        User user1 = getUser(user.getAuthToken());
        user1.setPassword(user.getPassword());
        userService.changePassword(user1);
        return result;
    }

    @RequestMapping("/editUser")
    public Result editUser(@RequestBody User user){
        Result result = new Result();
        User user1 = getUser(user.getAuthToken());
        user1.setPassword(user.getPhone());
        user1.setNick(user.getName());
        user1.setName(user.getName());
        userService.editUser(user1);
        return result;
    }

    private StringBuilder loadPermission(Long roleId,Menu parentMenu){
        StringBuilder str = new StringBuilder();
        List<Menu> list = menuRepository.findByRoleId(roleId,parentMenu.getId());
        if(list != null && list.size() != 0){
            str.append(String.format("<li><a class='has-arrow waves-effect waves-dark' href='#' aria-expanded='false'><i class='navFa fa %s'></i> <span class='hide-menu'>%s</span></a><ul aria-expanded='false' class='collapse'>",
            parentMenu.getIcon(),parentMenu.getName()));
            for (Menu menu : list) {
                str.append(loadPermission(roleId,menu));
            }
            str.append("</ul></li>");
        }else{
            if(parentMenu.getUrl() == null || "#".equals(parentMenu.getUrl())) {
                str.append(String.format("<li><a class='has-arrow waves-effect waves-dark' href='#' aria-expanded='false'><i class='navFa fa %s'></i> <span class='hide-menu'>%s</span></a><ul aria-expanded='false' class='collapse'>",
                        parentMenu.getIcon(),parentMenu.getName()));
            }else{
                str.append(String.format("<li><a href=\"javascript:loadMain('%s','%s')\"><i class='navFa fa %s'></i> <span>%s</span></a></li>",
                        parentMenu.getName(),parentMenu.getAttr1(),parentMenu.getIcon(),parentMenu.getName()));
            }
        }
        return str;
    }
}
