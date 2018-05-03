package cn.windy.kernel.service;

import cn.windy.kernel.model.Item;
import cn.windy.kernel.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 数据字典业务处理
 */
public interface IItemService extends IBaseService<Item,ItemRepository> {

    Page<Item> findByItem(Item item , Pageable pageable);

    void deleteByIds(Long[] ids);

    List<Item> findByType(String type);

    List<Item> findyByTypeAndValue(String type,String value);

}
