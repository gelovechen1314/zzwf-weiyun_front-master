package cn.windy.kernel.service.impl;

import cn.windy.exception.ServiceException;
import cn.windy.kernel.model.BaseModel;
import cn.windy.kernel.repository.BaseRepository;
import cn.windy.kernel.service.IBaseService;
import cn.windy.kernel.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * 基础业务逻辑处理类
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class BaseService<T extends BaseModel,R extends BaseRepository> implements IBaseService<T,R> {

    private Logger log = LoggerFactory.getLogger(BaseService.class);
    private BaseRepository baseRepository;
    private T t;

	public void init(){
        log.info("invoke init method ... ");
        if(baseRepository == null) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Type[] types = type.getActualTypeArguments();
            if (types.length < 2) throw new ServiceException("Service的实现的泛型不可以小于两个，第一个是实体类，第二个是实体类对应的Repository");
            Class<BaseRepository> clazz = (Class<BaseRepository>) types[1];
            baseRepository = SpringUtil.getBean(clazz);

            Class<T> tClass = (Class<T>)types[0];
            try {
                t = tClass.getDeclaredConstructor().newInstance();
            } catch (Exception  e) {
                log.error("{}",e);
            }
        }
    }

    @Transactional
    public T add(T t) {
        init();
        baseRepository.save(t);
        return t;
    }

    public T findById(Serializable id) {
        Optional<T> optional = findOne(id);
        if(optional.isPresent())
            return optional.get();
        return t;
    }

    @Transactional
    public T update(T t) {
        init();
        return (T) baseRepository.save(t);
    }

    public Optional<T> findOne(Serializable id) {
        init();
        Optional<T> optional = baseRepository.findById(id);
        return optional;
    }

    @Transactional
    public void delete(Serializable[] ids) {
        for (Serializable id : ids) {
            baseRepository.deleteById(id);
        }
    }


}
