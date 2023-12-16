package com.cybersoft.cozastore03.service.implementation;

import com.cybersoft.cozastore03.entity.UserEntity;

// Thang nay ko co annotation @Service, ma nam o ben thang ke thua
public interface LoginServiceImplementation {
//    boolean checkLogin(String username, String password);
    UserEntity checkLogin(String username, String password);
}
