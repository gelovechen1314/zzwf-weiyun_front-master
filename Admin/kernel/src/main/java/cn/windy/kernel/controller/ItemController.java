package cn.windy.kernel.controller;

import cn.windy.kernel.model.Item;
import cn.windy.kernel.service.IItemService;
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

@RestController
@RequestMapping("/kernel/item")
public class ItemController extends BaseController {

    private Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    IItemService itemService;

    @RequestMapping("/list")
    public Page<Item> list(Item item, Pagination pagination){
        return itemService.findByItem(item,pagination.getPageable());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Item item){
        Result result = new Result();
        item.setAddTime(DateUtil.getDate());
        item.setType("1");
        item.setAddUser(0L);
        try{
            itemService.add(item);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.info("保存数据字典信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Long id){
        Result result = new Result();
        result.setModel(itemService.findById(id));
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Item item){
        Result result = new Result();
        try {
            Item item1 = itemService.findById(item.getId());
            BeanCopy.beans(item, item1).ignoreNulls(true).copy();
            item1.setUpdateTime(DateUtil.getDate());
            itemService.update(item1);
            result.setModel(item1);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("修改数据字典信息发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            itemService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除数据字典发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

}
