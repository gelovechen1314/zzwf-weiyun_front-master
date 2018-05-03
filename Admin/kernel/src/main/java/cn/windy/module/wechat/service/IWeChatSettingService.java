package cn.windy.module.wechat.service;

import cn.windy.kernel.service.IBaseService;
import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.repository.WeChatSettingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWeChatSettingService extends IBaseService<WeChatSetting,WeChatSettingRepository> {

    Page<WeChatSetting> findBySetting(WeChatSetting setting , Pageable pageable);

    void deleteByIds(Long[] ids);

}
