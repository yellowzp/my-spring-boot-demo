package com.example.demoaop.controller;

import com.example.demoaop.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    @MyAnnotation
    @RequestMapping("/rest/MyTestController/getStr")
    public String getStr() {
        System.out.println("rest request!");
        return "hello world";
    }
}
