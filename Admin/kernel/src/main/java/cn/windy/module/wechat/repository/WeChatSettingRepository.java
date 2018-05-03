package cn.windy.module.wechat.repository;

import cn.windy.kernel.repository.BaseRepository;
import cn.windy.module.wechat.model.WeChatSetting;
import org.springframework.stereotype.Repository;

/**
 * 设置
 */
@Repository
public interface WeChatSettingRepository extends BaseRepository<WeChatSetting,Long> {
}
