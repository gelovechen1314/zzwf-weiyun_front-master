package cn.windy.module.wechat.controller;

import cn.windy.kernel.controller.BaseController;
import cn.windy.kernel.vo.Result;
import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.service.IWeChatSettingService;
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

@RestController
@RequestMapping("/weChatSetting")
public class WeChatSettingController extends BaseController {

    private Logger log = LoggerFactory.getLogger(WeChatSettingController.class);

    @Autowired
    IWeChatSettingService weChatSettingService;

    @RequestMapping("/list")
    public Page<WeChatSetting> list(WeChatSetting setting, Pagination pagination){
        return weChatSettingService.findBySetting(setting,pagination.getPageable());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody WeChatSetting setting){
        Result result = new Result();
        setting.setAddTime(DateUtil.getDate());
        setting.setAddUser(0L);
        try{
            weChatSettingService.add(setting);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.info("保存微信公众号设置发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Long id){
        Result result = new Result();
        result.setModel(weChatSettingService.findById(id));
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody WeChatSetting setting){
        Result result = new Result();
        try {
            WeChatSetting setting1 = weChatSettingService.findById(setting.getId());
            BeanCopy.beans(setting, setting1).ignoreNulls(true).copy();
            setting1.setUpdateTime(DateUtil.getDate());
            weChatSettingService.update(setting1);
            result.setModel(setting1);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("修改微信公众号设置发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            weChatSettingService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除微信公众号设置发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

}
