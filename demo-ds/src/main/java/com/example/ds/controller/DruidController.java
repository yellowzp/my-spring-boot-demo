package com.example.ds.controller;

import com.example.ds.constant.ResponseEntity;
import com.example.ds.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DruidController {

//    @Autowired
//    private Map<Object, Object> targetDataSources;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @PostMapping("/druid-dynamic/targetDataSources")
    public ResponseEntity<Object> targetDataSources() {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(dynamicDataSource.getTargetDataSourceMap().keySet());
        return rsp;
    }
}
