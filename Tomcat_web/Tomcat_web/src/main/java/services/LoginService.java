package services;

import entity.UserEntity;
import repository.UserRepository;

import java.util.List;

public class LoginService {
    private UserRepository userRepository = new UserRepository();
    public boolean checkLogin(String email, String password) {
        List<UserEntity> list = userRepository.findbyEmailAndPassword(email,password);
        return list.size() > 0;
    }
}
