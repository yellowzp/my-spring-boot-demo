package com.example.ds.runner;

import com.example.ds.datasource.DynamicDataSource;
import com.example.ds.entities.DataSourceEntity;
import com.example.ds.service.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(1)
@Component
public class DataSourceInitRunner implements ApplicationRunner {

    @Autowired
    private IDataSourceService dataSourceService;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<DataSourceEntity> li = dataSourceService.getList();
        for (DataSourceEntity e: li) {
            dynamicDataSource.addDataSource(e);
        }
    }
}
