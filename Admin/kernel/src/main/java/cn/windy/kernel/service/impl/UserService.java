package cn.windy.kernel.service.impl;

import cn.windy.kernel.model.User;
import cn.windy.kernel.repository.UserRepository;
import cn.windy.kernel.service.IUserService;
import cn.windy.util.StringUtil;
import cn.windy.util.encrypt.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService<User,UserRepository> implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Transactional(readOnly = true)
    public Page<User> findByUser(User user, Pageable pageable) {
        Specification<User> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(!StringUtil.isBlank(user.getAccount())){
                predicate.add(criteriaBuilder.like(root.get("account").as(String.class),"%"+user.getAccount()+"%"));
            }
            if(!StringUtil.isBlank(user.getName())){
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+user.getName()+"%"));
            }
            if(!StringUtil.isBlank(user.getPhone())){
                predicate.add(criteriaBuilder.like(root.get("phone").as(String.class),"%"+user.getPhone()+"%"));
            }

            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return userRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        delete(ids);
    }

    @Transactional
    public void changePassword(User user) {
        String hql = "update User user set user.password = :password where user.id=:id";
        Map<String,Object> map = new HashMap<>();
        map.put("password",MD5.encode(user.getPassword()));
        map.put("id",user.getId());
        userRepository.executeUpdate(hql,map);
    }

    @Transactional
    public void editUser(User user) {
        String hql = "update User user set user.phone=:phone,name=:name,nick=:nick where user.id=:id";
        Map<String,Object> map = new HashMap<>();
        map.put("phone",user.getPhone());
        map.put("name",user.getName());
        map.put("nick",user.getNick());
        map.put("id",user.getId());
        userRepository.executeUpdate(hql,map);
    }
}
