package com.example.demodatabase.service.impl;

import com.example.demodatabase.dao.IUserDao;
import com.example.demodatabase.entities.UserEntities;
import com.example.demodatabase.service.svcinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;
    @Override
    public List<UserEntities> getList() {
        return dao.getList();
    }
}
