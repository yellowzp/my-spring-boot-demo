package com.example.ds.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * targetDataSources 是我们在xml配置文件中注入的 dataSourceMaster 和 dataSourceSlave. afterPropertiesSet方法就是使用注入的
 * dataSourceMaster 和 dataSourceSlave来构造一个HashMap——resolvedDataSources
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 重写当前数据源的key获取方法
     * @return Long
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getCurrentDatasourceId();
    }

}
