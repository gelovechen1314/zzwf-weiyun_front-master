package cn.windy.module.wechat.controller;

import cn.windy.kernel.controller.BaseController;
import cn.windy.kernel.vo.Result;
import cn.windy.module.wechat.model.WeChatMenu;
import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.repository.WeChatMenuRepository;
import cn.windy.module.wechat.service.IWeChatMenuService;
import cn.windy.module.wechat.service.cache.WeChatSettingCache;
import cn.windy.module.wechat.util.api.MenuApi;
import cn.windy.util.DateUtil;
import cn.windy.util.Pagination;
import cn.windy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/weChatMenu")
public class WeChatMenuController extends BaseController{

    private Logger log = LoggerFactory.getLogger(WeChatMenuController.class);

    @Autowired
    IWeChatMenuService weChatMenuService;

    @Autowired
    WeChatMenuRepository weChatMenuRepository;


    @RequestMapping("/list")
    public Page<WeChatMenu> list(WeChatMenu menu , Pagination pagination){
        Pageable page = pagination.getPageable();
        return weChatMenuService.findByWeChatMenu(menu,page);
    }

    @RequestMapping("/menuJson")
    public String getMenuJson(){
        return "["+getMenuJson(0L)+"]";
    }

    @RequestMapping("/add")
    public Result add(@RequestBody WeChatMenu menu){
        Result result = new Result();
        try {
            menu.setAddTime(DateUtil.getDate());
            menu.setAddUser(0L);
            if(menu.getPid() == null)
                menu.setPid(0L);
            weChatMenuService.add(menu);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.error("添加微信菜单失败:",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            weChatMenuService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除微信信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    private String getMenuJson(Long pid){
        StringBuilder menuJson = new StringBuilder();
        List<WeChatMenu> list = weChatMenuRepository.findByPid(pid);
        if(list != null && list.size() > 0) { //
            for (WeChatMenu menu : list) {
                String childMenuJson = getMenuJson(menu.getId());
                if(!childMenuJson.toString().equals("")){
                    menuJson.append(String.format("{id:%d,name:'%s',children:[%s]},",menu.getId(),menu.getName(),childMenuJson));
                }else{
                    menuJson.append(String.format("{id:%d,name:'%s'},",menu.getId(),menu.getName()));
                }
            }
        }
        if(menuJson.length()>0)
            return menuJson.substring(0,menuJson.length()-1);
        return menuJson.toString();
    }

    @ResponseBody
    @RequestMapping("/import") //import
    public String import_() throws UnsupportedEncodingException {
        List<WeChatMenu> list = weChatMenuRepository.findByPid(0L);
        StringBuffer json = new StringBuffer("");
        WeChatSetting setting = WeChatSettingCache.getSetting();
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+setting.getAppId()+"&redirect_uri=%s&response_type=" +
                "code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        for (WeChatMenu menu : list) {
            List<WeChatMenu> children = weChatMenuRepository.findByPid(menu.getId());
            StringBuffer child = new StringBuffer();
            for (WeChatMenu childMenu : children) {
                child.append("{\"type\":\""+ StringUtil.clearNull(childMenu.getType())+"\",");
                child.append("\"name\":\""+StringUtil.clearNull(childMenu.getName())+"\",");
                child.append("\"key\":\""+StringUtil.clearNull(childMenu.getBtnKey())+"\",");
                child.append("\"url\":\""+String.format(url, URLEncoder.encode(StringUtil.clearNull(childMenu.getUrl()),"utf-8"))+"\",");
                child.append("\"appid\":\""+StringUtil.clearNull(childMenu.getAppId())+"\",");
                child.append("\"pagepath\":\""+StringUtil.clearNull(childMenu.getPagepath())+"\"},");
            }
            json.append("{\"type\":\""+StringUtil.clearNull(menu.getType())+"\",");
            json.append("\"name\":\""+StringUtil.clearNull(menu.getName())+"\",");
            json.append("\"key\":\""+StringUtil.clearNull(menu.getBtnKey())+"\",");
            json.append("\"url\":\""+String.format(url, URLEncoder.encode(StringUtil.clearNull(menu.getUrl()),"utf-8"))+"\",");
            json.append("\"appid\":\""+StringUtil.clearNull(menu.getAppId())+"\",");
            if(child.length()>0){
                json.append("\"sub_button\":["+child.substring(0,child.length()-1)+"],");
            }
            json.append("\"pagepath\":\""+StringUtil.clearNull(menu.getPagepath())+"\"},");
        }
        return MenuApi.execute("{\"button\":["+json.substring(0,json.length()-1)+"]}");
    }

    public static void main(String[] args) {
        System.out.println(Long.toHexString(20180305070203000l));
    }

}
