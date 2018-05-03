package cn.windy.module.wechat.service;

import cn.windy.kernel.service.IBaseService;
import cn.windy.module.wechat.model.WeChatMenu;
import cn.windy.module.wechat.repository.WeChatMenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWeChatMenuService extends IBaseService<WeChatMenu,WeChatMenuRepository> {

    Page<WeChatMenu> findAll(int page, int pageSize);

    Page<WeChatMenu> findByWeChatMenu(WeChatMenu menu, Pageable pageable);

    void deleteByIds(Long[] ids);

}
