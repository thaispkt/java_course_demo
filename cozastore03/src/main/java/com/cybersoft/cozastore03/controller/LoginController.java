package com.cybersoft.cozastore03.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import com.cybersoft.cozastore03.jwt.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @PostMapping("")
    public ResponseEntity<?> login() {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String secretKey = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("JWT secret key: " + secretKey);
        String data = jwtHelper.decryptToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZWxsbyBKV1QifQ" +
                ".cP1RQpLdw-mD_H8faswGz94zqpwvG38bbDGxWsTTZ2M");
        return new ResponseEntity<>(data, HttpStatus.OK);
//        return new ResponseEntity<>("Hello login page", HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(token);
        String jwtToken = jwtHelper.generateToken("hello JWT");
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }
}
