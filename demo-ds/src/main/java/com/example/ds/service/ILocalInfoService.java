package com.example.ds.service;


import com.example.ds.entities.LocalInfoEntity;

import java.util.List;

public interface ILocalInfoService {

    String getValueByVar(String var);

    List<LocalInfoEntity> getList();

}
