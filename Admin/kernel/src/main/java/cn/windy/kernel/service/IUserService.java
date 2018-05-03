package cn.windy.kernel.service;

import cn.windy.kernel.model.User;
import cn.windy.kernel.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IBaseService<User,UserRepository> {

    Page<User> findByUser(User user , Pageable pageable);

    void deleteByIds(Long[] ids);

    void changePassword(User user);
    void editUser(User user);

}
