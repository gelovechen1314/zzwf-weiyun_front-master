package cn.windy.kernel.repository;

import cn.windy.kernel.model.RoleMenu;
import cn.windy.kernel.model.RoleMenuPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 角色菜单repository
 */
@Repository
public interface RoleMenuRepository extends BaseRepository<RoleMenu,RoleMenuPK> {

    @Modifying
    @Query("delete from RoleMenu rm where rm.roleId=?1")
    void del(Long rid);

}
