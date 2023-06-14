package com.example.ds.controller;

import com.example.ds.constant.ResponseEntity;
import com.example.ds.datasource.DynamicDataSourceContextHolder;
import com.example.ds.service.ILocalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalInfoController {

    @Autowired
    private ILocalInfoService localInfoService;

    @GetMapping("/local-info/list")
    public ResponseEntity<Object> getList() {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(localInfoService.getList());
        return rsp;
    }

    @GetMapping("/local-info/value-by-var")
    public ResponseEntity<Object> getValueByVar(@RequestParam("var") String var) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(localInfoService.getValueByVar(var));
        return rsp;
    }

    @GetMapping("/local-info/value-by-datasource/")
    public ResponseEntity<Object> getValueByDataSource(@RequestParam("id") Long id, @RequestParam("var") String var) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        DynamicDataSourceContextHolder.setCurrentDatasourceId(id);
        rsp.setData(localInfoService.getValueByVar(var));
        return rsp;
    }


}
