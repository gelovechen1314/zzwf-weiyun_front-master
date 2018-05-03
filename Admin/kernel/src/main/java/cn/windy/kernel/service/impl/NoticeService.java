package cn.windy.kernel.service.impl;

import cn.windy.kernel.model.Notice;
import cn.windy.kernel.repository.NoticeRepository;
import cn.windy.kernel.service.INoticeService;
import cn.windy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService extends BaseService<Notice,NoticeRepository> implements INoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    public Page<Notice> findByNotice(Notice notice, Pageable pageable) {
        Specification<Notice> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(!StringUtil.isBlank(notice.getTitle())){
                predicate.add(criteriaBuilder.like(root.get("title").as(String.class),"%"+notice.getTitle()+"%"));
            }

            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return noticeRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        delete(ids);
    }
}
