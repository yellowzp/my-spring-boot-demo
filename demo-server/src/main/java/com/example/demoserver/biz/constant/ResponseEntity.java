package com.example.demoserver.biz.constant;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = -5932432473507487135L;

    private Integer code = 200;

    private String msg = "调用成功";

    private T data;
}
