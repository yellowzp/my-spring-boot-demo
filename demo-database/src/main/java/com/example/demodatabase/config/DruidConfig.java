package com.example.demodatabase.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: yellowzp
 * @date: 2023/3/11 21:40
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        //1. 配置了 @ConfigurationProperties("spring.datasource")
        //   就可以读取到application.yml的配置，注意：我们需要将bean注入到spring ioc容器中、bean中提供get\set方法
        //2. 我们就不需要调用DruidDataSource 对象的setXxx, 会自动关联

        DruidDataSource druidDataSource = new DruidDataSource();
        //druidDataSource.setUrl();
        //druidDataSource.setUsername();
        //druidDataSource.setPassword();
        return druidDataSource;
    }
}
