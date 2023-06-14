package com.example.ds.entities;


import lombok.Data;

/**
 * 数据源实体
 */
@Data
public class DataSourceEntity {

    private Long id;

    /**
     * 数据库展示名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 帐号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口
     */
    private String port;

    /**
     * 数据库名
     */
    private String database;

    /**
     * url
     */
    private String url;
}
