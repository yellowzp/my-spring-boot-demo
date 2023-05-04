package com.example.demodatabase.dao;

import com.example.demodatabase.entities.UserEntities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {

    List<UserEntities> getList();
}
