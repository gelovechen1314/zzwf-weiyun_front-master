package cn.windy.kernel.repository;

import cn.windy.kernel.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据字典 Repository
 */
@Repository
public interface ItemRepository extends BaseRepository<Item,Long> {

    List<Item> findByType(String type);

    List<Item> findByTypeAndValue(String type,String value);

}
