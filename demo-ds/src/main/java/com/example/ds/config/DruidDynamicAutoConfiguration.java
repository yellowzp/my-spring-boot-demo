package com.example.ds.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.ds.datasource.DynamicDataSource;
import com.example.ds.datasource.DynamicDataSourceContextHolder;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注入动态数据源相关bean
 */
@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@Configuration
public class DruidDynamicAutoConfiguration {

    /**
     * 暴露 targetDataSources 方便增删数据源
     * @return ...
     */
    @Bean
    public Map<Object, Object> targetDataSources() {
        return new HashMap<>();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return new DruidDataSourceBuilder().build();
    }

    /**
     * 多数据源管理类
     * Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @param masterDataSource ...
     * @param targetDataSources ...
     * @return ...
     */
    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(DataSource masterDataSource, Map<Object, Object> targetDataSources) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        targetDataSources.put(DynamicDataSourceContextHolder.MASTER_DATASOURCE_ID, masterDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }
}
