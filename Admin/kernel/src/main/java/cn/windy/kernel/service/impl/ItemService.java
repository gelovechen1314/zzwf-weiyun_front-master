package cn.windy.kernel.service.impl;

import cn.windy.kernel.model.Item;
import cn.windy.kernel.repository.ItemRepository;
import cn.windy.kernel.service.IItemService;
import cn.windy.redis.JedisUtil;
import cn.windy.redis.SerializeUtil;
import cn.windy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 数据字典业务逻辑
 */
@Service
public class ItemService extends BaseService<Item,ItemRepository> implements IItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public Page<Item> findByItem(Item item, Pageable pageable) {
        Specification<Item> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(!StringUtil.isBlank(item.getName())){
                predicate.add(criteriaBuilder.like(root.get("name").as(String.class),"%"+item.getName()+"%"));
            }
            if(!StringUtil.isBlank(item.getType())){
                predicate.add(criteriaBuilder.equal(root.get("type").as(String.class),item.getType()));
            }

            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return itemRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        delete(ids);
    }

    public List<Item> findByType(String type) {
        String key = "Item:"+type;
        Optional<List<Item>> optional = JedisUtil.getObject(key);
        if(!optional.isPresent()){
            List<Item> list = itemRepository.findByType(type);
            JedisUtil.set(key,SerializeUtil.serialize(list));
            optional = Optional.of(list);
        }
        return optional.get();
    }

    public List<Item> findyByTypeAndValue(String type, String value) {
        String key = "Item:"+type+":"+value;
        Optional<List<Item>> optional = JedisUtil.getObject(key);
        if(!optional.isPresent()){
            List<Item> list = itemRepository.findByTypeAndValue(type,value);
            JedisUtil.set(key,SerializeUtil.serialize(list));
            optional = Optional.of(list);
        }
        return optional.get();
    }
}
