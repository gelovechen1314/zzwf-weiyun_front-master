package cn.windy.kernel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class BaseRepositoryImpl<T, ID extends Serializable>  extends SimpleJpaRepository<T,Serializable>
        implements BaseRepository<T, Serializable>{
    /**
     * 持久化上下文
     */
    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<?> execute(String select,String count,String hqlFrom, Map<String, Object> params, Pageable pageable) {
        return execute(select+hqlFrom,count+hqlFrom,params,pageable);
    }

    @SuppressWarnings("unchecked")
	@Override
    public Page<?> execute(String select, String count, Map<String, Object> params, Pageable pageable) {
        Query query = entityManager.createQuery(select);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }

        query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return new PageImpl<>(query.getResultList(),pageable,count(count,params));
    }

    @SuppressWarnings("unchecked")
	@Override
    public Page<?> executeSql(String select, String count, Map<String, Object> params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(select);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }

        query.setFirstResult((pageable.getPageNumber())*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return new PageImpl<>(query.getResultList(),pageable,countSql(count,params));
    }

    @Override
    public List<?> execute(String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        return query.getResultList();
    }

    @Override
    public int executeUpdate(String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        return query.executeUpdate();
    }

    @Override
    public int executeSqlUpdate(String sql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        return query.executeUpdate();
    }

    private Long count(String hql,Map<String, Object> params){
        Query query = entityManager.createQuery(hql);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        return (Long) query.getSingleResult();
    }

    private Long countSql(String sql,Map<String, Object> params){
        Query query = entityManager.createNativeQuery(sql);
        if(params != null){
            for (String s : params.keySet()) {
                query.setParameter(s,params.get(s));
            }
        }
        return ((BigInteger) query.getSingleResult()).longValue();
    }

    public List<?> executeSql(String select, Map<String, Object> params, Pageable pageable) {
        Query query = entityManager.createNativeQuery(select);
        if (params != null) {
            for (String s : params.keySet()) {
                query.setParameter(s, params.get(s));
            }
        }

        if (pageable != null) {
            query.setFirstResult((pageable.getPageNumber()) * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }
}
