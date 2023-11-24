package com.cybersoft.cozastore03.service.implementation;
// Thang nay ko co annotation @Service, ma nam o ben thang ke thua
public interface LoginServiceImplementation {
    boolean checkLogin(String username, String password);
}
