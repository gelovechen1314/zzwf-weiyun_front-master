package cn.windy.kernel.spring;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableJpaRepositories(basePackages = "cn.windy.**.repository",
        repositoryFactoryBeanClass = KernelRepositoryFactoryBean.class)
@EnableSpringDataWebSupport
public class JpaDataConfig {
}
