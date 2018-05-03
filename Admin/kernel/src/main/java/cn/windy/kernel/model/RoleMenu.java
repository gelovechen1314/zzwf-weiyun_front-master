package cn.windy.kernel.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 角色和菜单关联
 */
@Entity
@Table(name = "windy_role_menu")
@IdClass(RoleMenuPK.class)
public class RoleMenu {
    private long roleId;
    private long menuId;

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "menu_id")
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenu roleMenu = (RoleMenu) o;
        return roleId == roleMenu.roleId &&
                menuId == roleMenu.menuId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, menuId);
    }
}
