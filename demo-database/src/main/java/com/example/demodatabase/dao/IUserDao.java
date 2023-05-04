package com.example.demodatabase.dao;

import com.example.demodatabase.entities.UserEntity;
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
