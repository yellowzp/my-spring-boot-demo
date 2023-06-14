package com.example.ds.controller;

import com.example.ds.constant.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DruidController {

    @Autowired
    private Map<Object, Object> targetDataSources;

    @PostMapping("/druid-dynamic/targetDataSources")
    public ResponseEntity<Object> targetDataSources() {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(targetDataSources);
        return rsp;
    }
}
