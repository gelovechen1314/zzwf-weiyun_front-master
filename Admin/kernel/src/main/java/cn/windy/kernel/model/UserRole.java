package cn.windy.kernel.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 用户和角色关联
 */
@Entity
@Table(name = "windy_user_role")
@IdClass(UserRolePK.class)
public class UserRole {
    private long userId;
    private long roleId;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return userId == userRole.userId &&
                roleId == userRole.roleId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, roleId);
    }
}
