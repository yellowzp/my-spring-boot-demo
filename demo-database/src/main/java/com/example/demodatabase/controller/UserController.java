package com.example.demodatabase.controller;

import com.example.demodatabase.constant.ResponseEntity;
import com.example.demodatabase.service.svcinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/api/user/list")
    public ResponseEntity<Object> getList() {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(userService.getList());
        return rsp;
    }

}
