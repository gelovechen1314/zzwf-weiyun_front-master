package cn.windy.module.wechat.service.impl;

import cn.windy.kernel.service.impl.BaseService;
import cn.windy.module.wechat.model.WeChatMenu;
import cn.windy.module.wechat.repository.WeChatMenuRepository;
import cn.windy.module.wechat.service.IWeChatMenuService;
import cn.windy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeChatMenuService extends BaseService<WeChatMenu,WeChatMenuRepository>
    implements IWeChatMenuService{

    @Autowired
    WeChatMenuRepository weChatMenuRepository;

    @Override
    public Page<WeChatMenu> findAll(int page, int pageSize) {
        Page<WeChatMenu> page1 = weChatMenuRepository.findAll(PageRequest.of(page,pageSize));
        return page1;
    }

    @Override
    public Page<WeChatMenu> findByWeChatMenu(WeChatMenu menu, Pageable pageable) {
        Specification<WeChatMenu> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(menu.getPid() != null){
                predicate.add(criteriaBuilder.equal(root.get("pid").as(Long.class),menu.getPid()));
            }
            if(!StringUtil.isBlank(menu.getName())){
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+menu.getName()+"%"));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return weChatMenuRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            weChatMenuRepository.deleteById(id);
        }
    }
}
