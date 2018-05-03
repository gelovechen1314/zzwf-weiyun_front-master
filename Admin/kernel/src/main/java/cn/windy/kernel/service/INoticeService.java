package cn.windy.kernel.service;

import cn.windy.kernel.model.Notice;
import cn.windy.kernel.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INoticeService extends IBaseService<Notice,NoticeRepository> {

    Page<Notice> findByNotice(Notice notice , Pageable pageable);

    void deleteByIds(Long[] ids);

}
