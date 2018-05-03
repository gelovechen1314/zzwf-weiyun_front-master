package cn.windy.kernel.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 动态获取spring容器实例
 */
@Configuration
public class SpringUtil implements ApplicationContextAware {


    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringUtil.applicationContext = context;
    }

    public static <R> R getBean(Class<R> clazz){
        return applicationContext.getBean(clazz);
    }

    @SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

}
