package cn.windy.kernel.controller;

import cn.windy.kernel.model.Role;
import cn.windy.kernel.repository.MenuRepository;
import cn.windy.kernel.service.IRoleService;
import cn.windy.kernel.vo.Result;
import cn.windy.util.DateUtil;
import cn.windy.util.Pagination;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kernel/role")
public class RoleController extends BaseController {

    private Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IRoleService roleService;
    @Autowired
    MenuRepository menuRepository;

    @RequestMapping("/list")
    public Page<Role> list(Role role, Pagination pagination){
        return roleService.findByUser(role,pagination.getPageable());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Role role){
        Result result = new Result();
        role.setAddTime(DateUtil.getDate());
        role.setFlag("1");
        role.setAddUser(0L);
        try{
            roleService.add(role);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.info("保存角色发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Long id){
        Result result = new Result();
        result.setModel(roleService.findById(id));
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Role role){
        Result result = new Result();
        try {
            Role role1 = roleService.findById(role.getId());
            BeanCopy.beans(role, role1).ignoreNulls(true).copy();
            role1.setUpdateTime(DateUtil.getDate());
            roleService.update(role1);
            result.setModel(role1);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("修改角色发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            roleService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除角色发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/savePermission")
    public Result savePermission(@RequestBody Map<String,String> map){
        Result result = new Result();
        try{
            String roleId = map.get("roleId");
            String ids = map.get("ids");
            roleService.savePermission(roleId,ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("保存角色权限发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/menuJson")
    public String getMenuJson(Long roleId){
        return "["+getMenuJson(0L,roleId)+"]";
    }

    private String getMenuJson(Long pid,Long roleId){
        StringBuilder menuJson = new StringBuilder();
        List<Object[]> list = menuRepository.findByPidAndRoleId(pid,roleId);
        if(list != null && list.size() > 0) { //
            for (Object[] menu : list) {
                String childMenuJson = getMenuJson(Long.parseLong(menu[0].toString()),roleId);
                if(!childMenuJson.toString().equals("")){
                    menuJson.append(String.format("{id:%d,name:'%s',children:[%s] %s},",menu[0],menu[1],childMenuJson,menu[2]==null?"":",checked:true"));
                }else{
                    menuJson.append(String.format("{id:%d,name:'%s' %s},",menu[0],menu[1],menu[2]==null?"":",checked:true"));
                }
            }
        }
        if(menuJson.length()>0)
            return menuJson.substring(0,menuJson.length()-1);
        return menuJson.toString();
    }

}
