package com.cybersoft.cozastore03.controller;

import com.cybersoft.cozastore03.payload.response.BaseResponse;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import com.cybersoft.cozastore03.jwt.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {
    private Gson gson = new Gson();
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
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
        logger.info("Request: Username: " + username);
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
//        authenticationManager.authenticate(token);
        Authentication authentication = authenticationManager.authenticate(token);
//        authentication.getAuthorities();
//        String jwtToken = jwtHelper.generateToken("hello JWT");

        String json = gson.toJson(authentication.getAuthorities());
        System.out.println("kiemtra " + json);
        String jwtToken = jwtHelper.generateToken(json);
        logger.info("Response: jwtToken=" + jwtToken);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(jwtToken);
        //System.out.println(jwtHelper.decodingData(jwtToken));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
