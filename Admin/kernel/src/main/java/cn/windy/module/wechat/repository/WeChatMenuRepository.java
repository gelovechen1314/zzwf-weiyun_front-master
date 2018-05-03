package cn.windy.module.wechat.repository;

import cn.windy.kernel.repository.BaseRepository;
import cn.windy.module.wechat.model.WeChatMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信菜单
 */
@Repository
public interface WeChatMenuRepository extends BaseRepository<WeChatMenu,Long> {

    List<WeChatMenu> findByPid(Long pid);

}
