package com.cybersoft.cozastore03.security;

import com.cybersoft.cozastore03.entity.UserEntity;
import com.cybersoft.cozastore03.service.LoginService;
import com.cybersoft.cozastore03.service.implementation.LoginServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//        if(loginServiceImplementation.checkLogin(username,password)) {
        UserEntity userEntity = loginServiceImplementation.checkLogin(username,password);
        // Truy van database đế lấy được user entity
        if (userEntity != null) {
            List<GrantedAuthority> listRoles = new ArrayList<>();
            SimpleGrantedAuthority role =
                    new SimpleGrantedAuthority(userEntity.getRole().getName());
            // Sau khi lấy được user entity thì lấy được role name của user, getRole() lấy role
            // ID của user, getName() lấy được role name của user.
            listRoles.add(role);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken("","",listRoles);
//        if(loginService.checkLogin(username,password)) {
            // Kiem tra user co ton tai hay ko
            return authenticationToken;
        }
        return null; // luon tra ve authenticate success
//        return null; // Luon tra ve authentication fail
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}
