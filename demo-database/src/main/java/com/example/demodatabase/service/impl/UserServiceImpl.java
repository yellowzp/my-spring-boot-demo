package com.example.demodatabase.service.impl;

import com.example.demodatabase.dao.IUserDao;
import com.example.demodatabase.entities.UserEntity;
import com.example.demodatabase.service.svcinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;
    @Override
    public List<UserEntity> getList() {
        return dao.getList();
    }

    @Override
    public int add(UserEntity user) {
        if (user.getUserId() == null || user.getUserId().equals("")) {
            throw new IllegalArgumentException("userId is null");
        }
        return this.dao.insert(user);
    }

    @Override
    public int modify(UserEntity user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("id is null");
        }
        return this.dao.updateById(user);
    }

    @Override
    public int remove(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
        return this.dao.deleteById(id);
    }
}
