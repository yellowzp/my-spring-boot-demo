package com.example.ds.dao;

import com.example.ds.entities.LocalInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ILocalInfoDao {

    String getValueByVar(@Param("var") String var);

    List<LocalInfoEntity> getList();
}
