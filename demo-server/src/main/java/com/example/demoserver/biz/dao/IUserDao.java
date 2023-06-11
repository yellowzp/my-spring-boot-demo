package com.example.demoserver.biz.dao;

import com.example.demoserver.biz.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserDao {

    List<UserEntity> getList();

    int insert(UserEntity user);

    int updateById(UserEntity user);

    int deleteById(@Param("id") Long id);
}
