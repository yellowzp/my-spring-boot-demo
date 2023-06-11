package com.example.ds.service;

import com.example.ds.entities.DataSourceEntity;

import java.util.List;

public interface IDataSourceService {

    List<DataSourceEntity> getList();

    int add(DataSourceEntity var);

    int modify(DataSourceEntity var);

    int remove(Long id);
}
