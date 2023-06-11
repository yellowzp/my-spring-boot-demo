package com.example.ds.controller;

import com.example.ds.constant.ResponseEntity;
import com.example.ds.entities.DataSourceEntity;
import com.example.ds.service.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {

    @Autowired
    private IDataSourceService dataSourceService;

    @PostMapping("/ds/getList")
    public ResponseEntity<Object> getList() {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(dataSourceService.getList());
        return rsp;
    }

    @PostMapping("/ds/add")
    public ResponseEntity<Object> add(DataSourceEntity var) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(dataSourceService.add(var));
        return rsp;
    }

    @PostMapping("/ds/modify")
    public ResponseEntity<Object> modify(DataSourceEntity var) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(dataSourceService.modify(var));
        return rsp;
    }

    @PostMapping("/ds/remove")
    public ResponseEntity<Object> remove(Long id) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(dataSourceService.remove(id));
        return rsp;
    }

}
