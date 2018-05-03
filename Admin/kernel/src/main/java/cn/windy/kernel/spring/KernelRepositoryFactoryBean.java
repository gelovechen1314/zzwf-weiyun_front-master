package cn.windy.kernel.spring;

import cn.windy.kernel.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * 创建一个自定义的FactoryBean去替代默认的工厂类
 * @param <R>
 * @param <T>
 * @param <I>
 */
public class KernelRepositoryFactoryBean <R extends JpaRepository<T, I>, T, I extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, I> {

    public KernelRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @SuppressWarnings("rawtypes")
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new CustomRepositoryFactory(em);
    }

    private static class CustomRepositoryFactory<T, I extends Serializable>
            extends JpaRepositoryFactory {

        private final EntityManager em;

        public CustomRepositoryFactory(EntityManager em) {
            super(em);
            this.em = em;
        }

        @SuppressWarnings("unchecked")
		protected Object getTargetRepository(RepositoryInformation information) {
            JpaEntityInformation<T, I> entityInformation = this.getEntityInformation((Class<T>) information.getDomainType());
            return new BaseRepositoryImpl<>(entityInformation, em);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseRepositoryImpl.class;
        }
    }

}