package cn.windy.kernel.repository;

import cn.windy.kernel.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理 Repository
 */
@Repository
public interface MenuRepository extends BaseRepository<Menu,Long> {

    @Query("select m from Menu m,RoleMenu rm where m.id = rm.menuId and rm.roleId = ?1 and m.pid = ?2 order by m.displayOrder")
    List<Menu> findByRoleId(Long roleId,Long pid);

    List<Menu> findByPid(Long pid);

    @Query(value="SELECT id,NAME,menu_id FROM (SELECT * FROM windy_menu m LEFT JOIN windy_role_menu rm " +
            " ON m.id = rm.menu_id AND rm.role_id = ?2) AS a " +
            " WHERE pid = ?1",nativeQuery = true)
    List<Object[]> findByPidAndRoleId(Long pid,Long roleId);

    Page<Menu> findByPid(Long pid, Pageable pageable);

    Page<Menu> findByNameLike(String name,Pageable pageable);

    Page<Menu> findByCodeLike(String code,Pageable pageable);

    Page<Menu> findByCodeLikeAndNameLike(String code,String name,Pageable pageable);
}
