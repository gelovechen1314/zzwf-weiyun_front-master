package cn.windy.kernel.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 配置druid数据源
 *
 */
@Configuration
public class DruidConfiguration {

    private Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Value("${druid.monitor.ip}")
    private String ip;
    @Value("${druid.monitor.username}")
    private String username;
    @Value("${druid.monitor.password}")
    private String password;
    @Value("${druid.monitor.reset}")
    private String reset;

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", ip);
        registrationBean.addInitParameter("loginUsername", username);
        registrationBean.addInitParameter("loginPassword", password);
        registrationBean.addInitParameter("resetEnable", reset);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> druidWebStatViewFilter() {
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        return registrationBean;

    }

    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.username}") String userName,
                                      @Value("${spring.datasource.password}") String password,
                                      @Value("${spring.datasource.maxActive}") int maxActive,
                                      @Value("${spring.datasource.filters}") String filters,
                                      @Value("${spring.datasource.initialSize}")
                                              int initialSize,
                                      @Value("${spring.datasource.minIdle}")
                                              int minIdle,
                                      @Value("${spring.datasource.maxWait}")
                                              int maxWait,
                                      @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
                                              int timeBetweenEvictionRunsMillis,
                                      @Value("${spring.datasource.minEvictableIdleTimeMillis}")
                                              int minEvictableIdleTimeMillis,
                                      @Value("${spring.datasource.validationQuery}")
                                              String validationQuery,
                                      @Value("${spring.datasource.testWhileIdle}")
                                              boolean testWhileIdle,
                                      @Value("${spring.datasource.testOnBorrow}")
                                              boolean testOnBorrow,
                                      @Value("${spring.datasource.testOnReturn}")
                                              boolean testOnReturn,
                                      @Value("${spring.datasource.poolPreparedStatements}")
                                              boolean poolPreparedStatements,
                                      @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
                                              int maxPoolPreparedStatementPerConnectionSize,
                                      @Value("${spring.datasource.connectionProperties}")
                                              String connectionProperties
                                      //@Value("${spring.datasource.useGlobalDataSourceStat}")
                                              //boolean useGlobalDataSourceStat

    ) {
        DruidDataSource dataSource = new DruidDataSource();
        /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        /*数据源补充配置*/
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setConnectionProperties(connectionProperties);
        //dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);

        try {
            dataSource.setFilters(filters);
            logger.info("Druid数据源初始化设置成功......");
        } catch (SQLException e) {
            logger.error("初始化数据源异常:",e);
            logger.info("Druid数据源filters设置失败......");
        }
        return dataSource;

    }
}