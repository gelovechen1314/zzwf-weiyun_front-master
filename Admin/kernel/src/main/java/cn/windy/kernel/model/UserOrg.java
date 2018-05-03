package cn.windy.kernel.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * 用户和组织关联
 */
@Entity
@Table(name = "windy_user_org")
@IdClass(UserOrgPK.class)
public class UserOrg {
    private long userId;
    private long orgId;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "org_id")
    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrg userOrg = (UserOrg) o;
        return userId == userOrg.userId &&
                orgId == userOrg.orgId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, orgId);
    }
}
