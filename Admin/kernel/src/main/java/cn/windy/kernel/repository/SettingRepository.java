package cn.windy.kernel.repository;

import cn.windy.kernel.model.Setting;
import org.springframework.stereotype.Repository;

/**
 * 系统配置 Repository
 */
@Repository
public interface SettingRepository extends BaseRepository<Setting,Long> {

}
