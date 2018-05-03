package cn.windy.kernel.controller;

import cn.windy.kernel.model.Menu;
import cn.windy.kernel.repository.MenuRepository;
import cn.windy.kernel.service.IMenuService;
import cn.windy.kernel.vo.Result;
import cn.windy.util.DateUtil;
import cn.windy.util.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kernel/menu")
public class MenuController extends BaseController {

    private Logger log = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    IMenuService menuService;
    @Autowired
    MenuRepository menuRepository;

    @RequestMapping("/list")
    public Page<Menu> list(Menu menu ,Pagination pagination){
        Pageable page = pagination.getPageable();
        return menuService.findByMenu(menu,page);
    }

    @RequestMapping("/menuJson")
    public String getMenuJson(){
        return "["+getMenuJson(0L)+"]";
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Menu menu){
        Result result = new Result();
        try {
            menu.setAddTime(DateUtil.getDate());
            menu.setAddUser(0L);
            if(menu.getPid() == null)
                menu.setPid(0L);
            menu.setHasChildren("1"); //表示有子菜单
            menu.setFlag("1");
            menuService.add(menu);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.error("添加系统菜单失败:",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            menuService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除菜单信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    private String getMenuJson(Long pid){
        StringBuilder menuJson = new StringBuilder();
        List<Menu> list = menuRepository.findByPid(pid);
        if(list != null && list.size() > 0) { //
            for (Menu menu : list) {
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

}
