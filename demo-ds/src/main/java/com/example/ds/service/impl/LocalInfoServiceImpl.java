package com.example.ds.service.impl;

import com.example.ds.dao.ILocalInfoDao;
import com.example.ds.entities.LocalInfoEntity;
import com.example.ds.service.ILocalInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LocalInfoServiceImpl implements ILocalInfoService {

    @Resource
    private ILocalInfoDao localInfoDao;


    @Override
    public String getValueByVar(String var) {
        return this.localInfoDao.getValueByVar(var);
    }

    @Override
    public List<LocalInfoEntity> getList() {
        return this.localInfoDao.getList();
    }
}
