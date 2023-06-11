package com.example.ds.dao;

import com.example.ds.entities.DataSourceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDataSourceDao {

    List<DataSourceEntity> getList();

    int add(DataSourceEntity var);

    int modify(DataSourceEntity var);

    int remove(@Param("id") Long id);

}
