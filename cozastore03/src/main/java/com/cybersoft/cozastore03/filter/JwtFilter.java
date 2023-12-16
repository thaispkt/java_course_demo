package com.cybersoft.cozastore03.filter;

import com.cybersoft.cozastore03.jwt.JwtHelper;
import com.cybersoft.cozastore03.security.CustomAuthenProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
    private Gson gson = new Gson();
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private CustomAuthenProvider authenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        Optional<String> tokenOptional = Optional.ofNullable(bearerToken);
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//        if (bearerToken != null && !bearerToken.isEmpty()) {
//            if(tokenOptional.isPresent()) {
            if(tokenOptional.filter(data -> data.startsWith("Bearer ")).isPresent()) {
                String token = tokenOptional.get().substring(7);
                System.out.println("token=" + token);
                if(!token.isEmpty()) {
                    String data = jwtHelper.decryptToken(token);
                    // tạo ra custom type để Gson hỗ trợ parse JSON kiểu list
//                    Type listType = new TypeToken<List<GrantedAuthority>>(){}.getType();
//                    GrantedAuthority là 1 interface không có key ROLE
                    Type listType = new TypeToken<List<SimpleGrantedAuthority>>(){}.getType();

                    List<GrantedAuthority> listRoles = gson.fromJson(data,listType);
                    logger.info("data = " + data + " size List Role "+ listRoles.size());
                    if(data != null) {
                        // Tạo SecurityContextHolder để bypass qua các filter của Security
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("","", listRoles);
//                        UsernamePasswordAuthenticationToken authenticationToken = new
//                        UsernamePasswordAuthenticationToken("","", new ArrayList<>("ADMIN"));

                        SecurityContext securityContext = SecurityContextHolder.getContext();
                        securityContext.setAuthentication(authenticationToken);

                    }
                }
//                tokenOptional.stream().map(data -> data.substring(7));

//            String token = bearerToken.substring(7).trim();
//
//            try {
//                String data = jwtHelper.decryptToken(token);
//                if (data != null) {
//                    Authentication authentication = authenticationProvider.authenticate(data);
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    logger.debug("Authenticated with token: {}", token);
//                } else {
//                    logger.error("Invalid token or token could not be decrypted");
//                }
//            } catch (Exception e) {
//                logger.error("Token validation error: {}", e.getMessage());
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//                return;
//            }
        }

        filterChain.doFilter(request, response);
    }
}
