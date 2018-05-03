package cn.windy.kernel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 所有 Repository 基类
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {

    Page<?> execute(String select,String count,String hqlFrom, Map<String,Object> params, Pageable pageable);

    Page<?> execute(String select,String count,Map<String,Object> params, Pageable pageable);
    Page<?> executeSql(String select,String count,Map<String,Object> params, Pageable pageable);

    List<?> execute(String hql, Map<String,Object> params);

    /**
     * 执行更新语句
     * @param hql
     */
    int executeUpdate(String hql,Map<String,Object> params);

    int executeSqlUpdate(String sql,Map<String,Object> params);

    List<?> executeSql(String select, Map<String, Object> params, Pageable pageable);
}
