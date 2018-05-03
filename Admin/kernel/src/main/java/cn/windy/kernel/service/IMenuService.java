package cn.windy.kernel.service;

import cn.windy.kernel.model.Menu;
import cn.windy.kernel.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 菜单业务处理
 */
public interface IMenuService extends IBaseService<Menu,MenuRepository> {

    Page<Menu> findAll(int page,int pageSize);

    Page<Menu> findByMenu(Menu menu, Pageable pageable);

    void deleteByIds(Long[] ids);

}
