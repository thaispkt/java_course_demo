package services;

import entity.UserEntity;
import repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginService {
    private UserRepository userRepository = new UserRepository();
    public boolean checkLogin(String email, String password, String remember,
                              HttpServletResponse resp) {
        List<UserEntity> list = userRepository.findbyEmailAndPassword(email,password);
        boolean isSucces = list.size() > 0;
        // Nếu khác null tức là người dùng có check lưu credentical
        if(remember != null) {
            Cookie cookieEmail = new Cookie("email", email);
            Cookie cookiePassword = new Cookie("password", password);
            resp.addCookie(cookieEmail);
            resp.addCookie(cookiePassword);
        }
        return isSucces;
    }
}
