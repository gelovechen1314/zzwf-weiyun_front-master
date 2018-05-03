package cn.windy.kernel.controller;

import cn.windy.kernel.model.User;
import cn.windy.kernel.service.IUserService;
import cn.windy.kernel.vo.Result;
import cn.windy.util.DateUtil;
import cn.windy.util.Pagination;
import cn.windy.util.encrypt.MD5;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kernel/user")
public class UserController extends BaseController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @RequestMapping("/list")
    public Page<User> list(User user, Pagination pagination){
        return userService.findByUser(user,pagination.getPageable());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody User user){
        Result result = new Result();
        user.setAddTime(DateUtil.getDate());
        user.setCode(user.getAccount());
        user.setType("1");
        user.setAddUser(0L);
        user.setUserFrom("1");
        user.setFlag("1");
        user.setSharedRevenueRate(0);
        user.setPwdEncrypt("1");
        user.setPassword(MD5.encode(user.getPassword()));
        user.setSex("1");
        try{
            userService.add(user);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.info("保存用户信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Long id){
        Result result = new Result();
        result.setModel(userService.findById(id));
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        Result result = new Result();
        try {
            User user1 = userService.findById(user.getId());
            BeanCopy.beans(user, user1).ignoreNulls(true).copy();
            user1.setUpdateTime(DateUtil.getDate());
            userService.update(user1);
            result.setModel(user1);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("保存用户信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            userService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除用户信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }
}
