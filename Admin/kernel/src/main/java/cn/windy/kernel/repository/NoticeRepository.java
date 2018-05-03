package cn.windy.kernel.repository;

import cn.windy.kernel.model.Notice;
import org.springframework.stereotype.Repository;

/**
 * 公告
 */
@Repository
public interface NoticeRepository extends BaseRepository<Notice,Long> {
}
