package com.cybersoft.cozastore03.security;

import com.cybersoft.cozastore03.service.LoginService;
import com.cybersoft.cozastore03.service.implementation.LoginServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenProvider implements AuthenticationProvider {
    @Autowired
//    private LoginService loginService;
    private LoginServiceImplementation loginServiceImplementation; // loginServiceImplementation
    // = new LoginServiceImplementation()
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        System.out.println("Kiem tra chung thuc: username=" + username + " - password:" + password);
        if(loginServiceImplementation.checkLogin(username,password)) {
//        if(loginService.checkLogin(username,password)) {
            // Kiem tra user co ton tai hay ko
            return authentication;
        }
        return null; // luon tra ve authenticate success
//        return null; // Luon tra ve authentication fail
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
