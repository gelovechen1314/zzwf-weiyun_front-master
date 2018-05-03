package cn.windy.kernel.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 用户和组织关联复合主銉
 */
@SuppressWarnings("serial")
public class UserOrgPK implements Serializable {
    private long userId;
    private long orgId;

    @Column(name = "user_id")
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "org_id")
    @Id
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
        UserOrgPK userOrgPK = (UserOrgPK) o;
        return userId == userOrgPK.userId &&
                orgId == userOrgPK.orgId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, orgId);
    }
}
