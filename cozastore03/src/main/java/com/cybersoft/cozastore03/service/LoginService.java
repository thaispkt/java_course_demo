package com.cybersoft.cozastore03.service;


import com.cybersoft.cozastore03.entity.UserEntity;
import com.cybersoft.cozastore03.repository.UserRepository;
import com.cybersoft.cozastore03.service.implementation.LoginServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//public class LoginService {
public class LoginService implements LoginServiceImplementation {
    @Autowired
    @Lazy // de tranh cycle loop, khi duoc goi toi thi moi xu ly
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkLogin(String username, String password) {
        UserEntity userEntity = userRepository.findByEmail(username);
        // Nếu truy vấn có dữ liệu nghĩa là user có tồn tại
        if(userEntity != null) {
            // kiểm tra password trong database có match với password mà user truyền lên hay ko
            if(passwordEncoder.matches(password,userEntity.getPassword())) {
                return true;
            }
        }
        return false;
    }
    /*
    public boolean checkLogin(String username, String password) {
        UserEntity userEntity = userRepository.findByEmail(username);
        // Nếu truy vấn có dữ liệu nghĩa là user có tồn tại
        if(userEntity != null) {
            // kiểm tra password trong database có match với password mà user truyền lên hay ko
            if(passwordEncoder.matches(password,userEntity.getPassword())) {
                return true;
            }
        }
        return false;
    }
     */
}
