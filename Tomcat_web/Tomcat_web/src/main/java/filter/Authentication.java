package filter;

import mySQLConfig.MySqlConfig;
import entity.UserEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// MVC - Model - View - Controller -> ko dùng. Dùng Strategy design pattern
// Controller: chỉ dùng chứa các class khai báo path và nhận parameter (Lưu ý: ko xử lý logic code)
// Service: chứa các class để xử lý logic code cho các controller tương ứng
// Repository: chứa các class trả ra dữ liệu các câu query liên quan đến các table trong dâtabase
// (tức là chỉ thực thi câu query SQL và trả ra kết quả câu query (Lưu ý: ko xử lý ko logic code)
// Controller <-> Service <-> Repository
@WebFilter(filterName = "authenFilter", urlPatterns = {"/role-add"})
public class Authentication implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Activated authentication filter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String email = "";
        String password = "";
        String contextPath = req.getContextPath();
        System.out.println("Kiem tra:" + contextPath);
        // chuyển req từ ServletRequest sang HttpServletRequest để có nhiều method support hơn
        // Lấy danh sách cookie user gửi lên thông qua request
        try {
            Cookie[] cookies = req.getCookies();
            if(cookies != null) {
                for (Cookie cookie: cookies) {
                    if(cookie.getName().equals("email")) {
                        email = cookie.getValue();
                    }
                    if(cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // trim(): cắt khoảng trắng (space/tab) của username phòng khi trường hợp user gõ khoảng
        // trắng trước username và sau username
        if(email.trim().length() > 0 && password.trim().length() > 0) {
            String query = "SELECT *\n" +
                    "FROM users u\n" +
                    "WHERE u.email = ? AND u.password = ?";
            // Bước 3: Mở kết nối CSDL và truyền câu query cho JDBC thông qua PrepareStatement
//        Connection connection = MySqlConfig.getConnection();
            Connection connection = MySqlConfig.getConnection();

            // Đã đăng nhập rồi
            // Cho phép đi vào link mà người dùng đang gọi mà kích hoạt filter
//            filterChain.doFilter(req, resp);
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
                    System.out.println("Filter: Login successfully");
                    filterChain.doFilter(req,resp);
                    // Nếu remember khác NULL tức là người dùng có check vào lưu tài khoản
                    // Nhớ checkbox Remember để vô đk này
                } else {
                    System.out.println("Filter: Login failure");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            // chưa đăng nhập, redirect về trang login
             resp.sendRedirect(contextPath + "/login");
        }
    }
}
