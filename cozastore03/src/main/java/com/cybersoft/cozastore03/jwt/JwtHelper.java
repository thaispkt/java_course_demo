package com.cybersoft.cozastore03.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtHelper {
    // Giúp ly giá trị khai báo bên file application.properties
    // Lưu ý @Value chỉ hoạt động khi class được đưa lên IOC
    @Value("${token.key}")
    private String secretKeyBase64;

    private int expiredTime = 8 * 60 * 60 * 1000;
    public String generateToken(String data) {
        // Chuyển key đã lưu trữ từ dạng base 64 sang dạng binary, kiểu SecretKey
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKeyBase64));
        Date date = new Date();
//        long fututeMiliseconds = Calendar.getInstance().getTimeInMillis();
        long futureMilisecond = date.getTime() + expiredTime;
        Date futureDate = new Date(futureMilisecond);
//        System.out.println("Debug futureMilisecond = " + futureMilisecond);
//        System.out.println("Debug futureDate = " + futureDate.toString());
        return Jwts.builder().subject(data).signWith(key).compact(); // compact() hàm để mã hóa
    }

    public String decryptToken(String jwtToken) {
        // Convert the stored key from base64 to binary format, SecretKey type
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKeyBase64));
        String data = null;

        try {
            // Decode the JWT token using the secret key
            data = Jwts.parser().verifyWith(key).build()
                    .parseSignedClaims(jwtToken)
                    .getPayload()
                    .getSubject();
        } catch (JwtException e) {
            System.out.println("Error JWT parsing: " + e.getMessage());
        }
        return data;
    }
}
