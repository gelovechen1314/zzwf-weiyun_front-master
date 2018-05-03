package cn.windy.kernel.service.impl;

import cn.windy.kernel.model.Role;
import cn.windy.kernel.model.RoleMenu;
import cn.windy.kernel.repository.RoleMenuRepository;
import cn.windy.kernel.repository.RoleRepository;
import cn.windy.kernel.service.IRoleService;
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
public class RoleService extends BaseService<Role,RoleRepository> implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMenuRepository roleMenuRepository;

    @Transactional(readOnly = true)
    public Page<Role> findByUser(Role item, Pageable pageable) {
        Specification<Role> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(!StringUtil.isBlank(item.getName())){
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+item.getName()+"%"));
            }
            if(!StringUtil.isBlank(item.getCode())){
                predicate.add(criteriaBuilder.equal(root.get("code").as(String.class),item.getCode()));
            }

            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return roleRepository.findAll(specification,pageable);
    }

    @Transactional(readOnly = false)
    public void deleteByIds(Long[] ids) {
        delete(ids);
    }

    @Transactional
    public void savePermission(String roleId, String ids) {
        Long rid = Long.parseLong(roleId);

        //先删除原有权限,再添加新权限
        roleMenuRepository.del(rid);

        if(ids.startsWith(",")){
            ids = ids.substring(1);
        }
        for (String mid : ids.split(",")) {
            RoleMenu rm = new RoleMenu();
            rm.setMenuId(Long.parseLong(mid));
            rm.setRoleId(rid);
            roleMenuRepository.save(rm);
        }
    }
}
