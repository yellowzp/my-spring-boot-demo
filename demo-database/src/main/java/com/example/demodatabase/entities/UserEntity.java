package com.example.demodatabase.entities;

import lombok.Data;

@Data
public class UserEntity {

    private Long id;

    private String userId;

    private String userName;

    private String password;
}
