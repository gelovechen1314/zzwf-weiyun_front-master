package cn.windy.kernel.service;

import cn.windy.kernel.repository.BaseRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * 所有service接口的父接口，必须继承
 */
@SuppressWarnings("rawtypes")
public interface IBaseService<T,R extends BaseRepository> {
    T add(T t);

    T findById(Serializable id);

    T update(T t);

    Optional<T> findOne(Serializable id);

    void delete(Serializable []ids);

}
