package prototype;

import mySQLConfig.MySqlConfig;
import entity.UserEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "loginServlet", urlPatterns = {"/login-bk"})
public class LoginServlet extends HttpServlet {
    // GET, POST => Methods cách thức HTTP client gọi đường dẫn

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = req.getSession();
        String likeCount = (String) session.getAttribute("like-count");
        System.out.println("test Debug: Like count: " + likeCount);
//		super.doGet(req, resp);
        //Hiển thị nọi dug file html khi người dùng gọi link/login
        // Tạo cookie
//        Cookie cookie = new Cookie("username", "thainguyen");
//        cookie.setMaxAge(15*60);
//        Cookie Passwordcookie = new Cookie("password", "Pass@2020");
//        resp.addCookie(cookie);
//        resp.addCookie(Passwordcookie);
//        Lấy danh sách cookie từ request người dùng
        Cookie[] cookieList = req.getCookies();
        String email = "";
        String password = "";
        for(Cookie cookie: cookieList) {
            if(cookie.getName().equals("email")) {
//                System.out.println("username: " + cookie.getValue());
                email = cookie.getValue();
            }
            if(cookie.getName().equals("password")) {
//                System.out.println("password: " + cookie.getValue());
                password = cookie.getValue();
            }
        }
        // Trả giá trị tham ssoo cho file JSPở requestDispatcher
        req.setAttribute("email", email);
        req.setAttribute("password", password);
        // Session
        HttpSession save_session = req.getSession();
        save_session.setAttribute("like-count","3");
        // Get session
//        req.setAttribute();
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // Bước 1: nhận parameter user truyền lên
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        System.out.println("Remember : " + remember);
        System.out.println("Debug POST: email = " + email);
        System.out.println("Debug POST: password = " + password);
        // Bước 2: Chuẩn bị câu query
//        String query = "SELECT *\n" +
//                "FROM users u\n" +
//                "WHERE u.email = 'nguyenduythai@gmail.com' AND u.password = 'Coca@123'";
        String query = "SELECT *\n" +
                "FROM users u\n" +
                "WHERE u.email = ? AND u.password = ?";
        // Bước 3: Mở kết nối CSDL và truyền câu query cho JDBC thông qua PrepareStatement
//        Connection connection = MySqlConfig.getConnection();
        Connection connection = MySqlConfig.getConnection();
        // Bước 4: Truyền câu query vào CSDL
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // Gán giá trị cho tham số dấu chấm ? bên trong câu query
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            // Bước 5: Thông báo cho DBMS biết và thực thi câu query
            // Các cách thực thi
            // executeQuery : Dành cho câu truy vấn là câu SELECT => luôn tr về ResultSet
            // executeUpdate: Dành cho câu truy vấn còn lại ngooài câu SELECT (INSERT, UPDATE,
            // DELETE) => trả về True/False (success/failure)

            ResultSet resultSet = preparedStatement.executeQuery();
            // Mỗi dòng là 1 đối tượng
            // Trả về sẽ dùng list lưu trữ các đối tượng
            //
            List UserList = new ArrayList<UserEntity>();
            // Bước 6: Duyệt từng dòng dữ liệu query được và gán vào trong List<UserEntity>
            while(resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("id"));
                // resultSet.getInt(database column name): lấy giá trị của cột id gắn vằo thuộc
                // tính id của user entity
                entity.setFullname(resultSet.getString("fullname"));
                UserList.add(entity);
            }
            // Kiểm tra đăng nhập bằng cách kiểm tra UserList cos giá trị hay không
            if(UserList.size() > 0) {
                System.out.println("Login successfully");
                // Nếu remember khác NULL tức là người dùng có check vào lưu tài khoản
                // Nhớ checkbox Remember để vô đk này
                if(remember != null) {
                    Cookie cookieEmail = new Cookie("email", email);
                    Cookie cookiePassword = new Cookie("password", password);
                    resp.addCookie(cookieEmail);
                    resp.addCookie(cookiePassword);
                }
            } else {
                System.out.println("Login failure");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        PreparedStatement statement = MySqlConfig.getConnection().pre
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}