package cn.windy.kernel.repository;

import cn.windy.kernel.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理 Repository
 */
@Repository
public interface UserRepository extends BaseRepository<User,Long> {

    List<User> findByAccount(String account);

    List<User> findByPhone(String phone);

    List<User> findByType(String type);

    List<User> findByUserFrom(String userFrom);

}
