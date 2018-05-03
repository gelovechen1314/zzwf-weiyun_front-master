package cn.windy.kernel.repository;

import cn.windy.kernel.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色管理 Repository
 */
@Repository
public interface RoleRepository extends BaseRepository<Role,Long> {

    @Query("select r from Role r,UserRole ur where r.id = ur.roleId and ur.userId=?1")
    List<Role> findByUserId(Long userId);

}
