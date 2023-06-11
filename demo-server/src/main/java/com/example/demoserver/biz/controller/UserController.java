package com.example.demoserver.biz.controller;

import com.example.demoserver.biz.constant.ResponseEntity;
import com.example.demoserver.biz.entities.UserEntity;
import com.example.demoserver.biz.service.svcinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/api/user/add")
    public ResponseEntity<Object> add(UserEntity user) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(userService.add(user));
        return rsp;
    }

    @PostMapping("/api/user/modify")
    public ResponseEntity<Object> modify(UserEntity user) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(userService.modify(user));
        return rsp;
    }

    @PostMapping("/api/user/remove/{id}")
    public ResponseEntity<Object> remove(@PathVariable(value = "id") Long id) {
        ResponseEntity<Object> rsp = new ResponseEntity<>();
        rsp.setData(userService.remove(id));
        return rsp;
    }

}
