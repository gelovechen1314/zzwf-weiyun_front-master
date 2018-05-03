package cn.windy.kernel.service.impl;

import cn.windy.kernel.model.Menu;
import cn.windy.kernel.repository.MenuRepository;
import cn.windy.kernel.service.IMenuService;
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

/**
 * 菜单业务处理逻辑
 */
@Service
public class MenuService extends BaseService<Menu,MenuRepository> implements IMenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Page<Menu> findAll(int page, int pageSize) {
        Page<Menu> page1 = menuRepository.findAll(PageRequest.of(page,pageSize));
        return page1;
    }

    @Transactional(readOnly = true)
    public Page<Menu> findByMenu(Menu menu, Pageable pageable) {
        Specification<Menu> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(menu.getPid() != null){
                predicate.add(criteriaBuilder.equal(root.get("pid").as(Long.class),menu.getPid()));
            }
            if(!StringUtil.isBlank(menu.getName())){
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+menu.getName()+"%"));
            }
            if(!StringUtil.isBlank(menu.getCode())){
                predicate.add(criteriaBuilder.like(root.get("code").as(String.class),"%"+menu.getCode()+"%"));
            }
            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return menuRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        delete(ids);
    }

}
