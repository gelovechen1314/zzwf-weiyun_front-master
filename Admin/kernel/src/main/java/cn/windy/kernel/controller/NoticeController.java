package cn.windy.kernel.controller;

import cn.windy.kernel.model.Notice;
import cn.windy.kernel.service.IItemService;
import cn.windy.kernel.service.INoticeService;
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
@RequestMapping("/kernel/notice")
public class NoticeController extends BaseController {

    private Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    IItemService itemService;
    @Autowired
    INoticeService noticeService;

    @RequestMapping("/list")
    public Page<Notice> list(Notice notice, Pagination pagination){
        return noticeService.findByNotice(notice,pagination.getPageable());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Notice notice){
        Result result = new Result();
        notice.setAddTime(DateUtil.getDate());
        notice.setAddUser(0L);
        try{
            noticeService.add(notice);
            result.setMessage("操作成功。");
        }catch (Exception e){
            log.info("保存公告发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/edit")
    public Result edit(Long id){
        Result result = new Result();
        result.setModel(noticeService.findById(id));
        return result;
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Notice notice){
        Result result = new Result();
        try {
            Notice notice1 = noticeService.findById(notice.getId());
            BeanCopy.beans(notice, notice1).ignoreNulls(true).copy();
            notice1.setUpdateTime(DateUtil.getDate());
            noticeService.update(notice1);
            result.setModel(notice1);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("修改公告发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        Result result = new Result();
        try{
            noticeService.deleteByIds(ids);
            result.setMessage("操作成功");
        }catch (Exception e){
            log.info("删除公告发生异常",e);
            result.setCode("0");
            result.setMessage("发生异常："+e.getMessage());
        }
        return result;
    }

}
