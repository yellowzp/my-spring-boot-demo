package com.example.ds.service.impl;

import com.example.ds.dao.IDataSourceDao;
import com.example.ds.entities.DataSourceEntity;
import com.example.ds.service.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceServiceImpl implements IDataSourceService {

    @Autowired
    private IDataSourceDao dataSourceDao;

    @Override
    public List<DataSourceEntity> getList() {
        return this.dataSourceDao.getList();
    }

    @Override
    public int add(DataSourceEntity var) {
        return this.dataSourceDao.add(var);
    }

    @Override
    public int modify(DataSourceEntity var) {
        return this.dataSourceDao.modify(var);
    }

    @Override
    public int remove(Long id) {
        return this.dataSourceDao.remove(id);
    }
}
