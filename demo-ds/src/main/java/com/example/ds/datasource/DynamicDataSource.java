package com.example.ds.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.ds.entities.DataSourceEntity;
import com.example.ds.enums.DataSourceTypeEnum;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * targetDataSources 是我们在xml配置文件中注入的 dataSourceMaster 和 dataSourceSlave. afterPropertiesSet方法就是使用注入的
 * dataSourceMaster 和 dataSourceSlave来构造一个HashMap——resolvedDataSources
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private final DataSourceProperties dataSourceProperties;

    /**
     * 外部生存targetDataSource 方便增删
     */
    private final Map<Object, Object> targetDataSourceMap = new HashMap<>();

    /**
     * 重写当前数据源的key获取方法
     * @return Long
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getCurrentDatasourceId();
    }


    /**
     * ...
     * @return ...
     */
    public Map<Object, Object> getTargetDataSourceMap() {
        return targetDataSourceMap;
    }

    public synchronized void addDataSource(DataSourceEntity entity) {
        dataSourceProperties.setUsername(entity.getAccount());
        dataSourceProperties.setPassword(entity.getPassword());
        dataSourceProperties.setUrl(entity.getUrl());
        dataSourceProperties.setDriverClassName(DataSourceTypeEnum.getDriverNameByType(entity.getType()));
        DruidDataSource newDataSource = (DruidDataSource) dataSourceProperties.initializeDataSourceBuilder().build();
        targetDataSourceMap.put(entity.getId(), newDataSource);
        this.afterPropertiesSet();
    }

    public synchronized void removeDataSource(Long id) {
        if (targetDataSourceMap.containsKey(id)) {
            DruidDataSource dataSource = (DruidDataSource) targetDataSourceMap.get(id);
            dataSource.close();
            targetDataSourceMap.remove(id);
        }
    }

    public DynamicDataSource(DataSourceProperties dataSourceProperties, DataSource masterDataSource) {
        this.dataSourceProperties = dataSourceProperties;
        targetDataSourceMap.put(DynamicDataSourceContextHolder.MASTER_DATASOURCE_ID, masterDataSource);
        this.setTargetDataSources(targetDataSourceMap);
        this.setDefaultTargetDataSource(masterDataSource);
        this.afterPropertiesSet();
    }

}
