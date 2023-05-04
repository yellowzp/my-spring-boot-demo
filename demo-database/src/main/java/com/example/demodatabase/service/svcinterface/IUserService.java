package com.example.demodatabase.service.svcinterface;

import com.example.demodatabase.entities.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> getList();

    int add(UserEntity user);

    int modify(UserEntity user);

    int remove(Long id);

}
