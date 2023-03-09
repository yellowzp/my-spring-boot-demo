package com.example.demoaop.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @RequestMapping ("/rest/myController/getStr")
    public String getStr() {
        System.out.println("rest request!");
        return "hello world";
    }
}
