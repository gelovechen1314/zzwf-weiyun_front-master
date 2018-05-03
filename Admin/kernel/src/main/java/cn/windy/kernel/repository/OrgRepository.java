package cn.windy.kernel.repository;

import cn.windy.kernel.model.Org;
import org.springframework.stereotype.Repository;

/**
 * 组织管理 Repository
 */
@Repository
public interface OrgRepository extends BaseRepository<Org,Long> {

}
