package com.example.demoserver.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HttpController {

    @Autowired
    private HttpTools httpTools;

//    @GetMapping("/test/doGet")
//    public String doGet() {
//        String url = "https://devpress-api.csdn.net/api/internal/blog/nsInfo/blog/108286191";
//        httpTools.doGet(url, new HashMap<>());
//    }
}
