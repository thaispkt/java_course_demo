package repository;

import entity.UserEntity;
import mySQLConfig.MySqlConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Chứa tất cả các câu quy liên quan tới bản User
SELECT: đại diện cho chữ find
WHERE: đại diện bởi chữ by
 */
public class UserRepository {
    /*
    select * -- findByEMailAndPassword
    from users u
    where u.email = '' and u.pwd = ''
     */
    public List<UserEntity> findbyEmailAndPassword(String email, String password) {
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
        // Tạo list UserEntity để lưu trữ từng dòng dữ liệu query được
        List UserList = new ArrayList<UserEntity>();
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

            // Bước 6: Duyệt từng dòng dữ liệu query được và gán vào trong List<UserEntity>
            while (resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("id"));
                // resultSet.getInt(database column name): lấy giá trị của cột id gắn vằo thuộc
                // tính id của user entity
                entity.setFullname(resultSet.getString("fullname"));
                UserList.add(entity);
            }

        } catch (SQLException e) {
//            throw new RuntimeException(e);
            System.out.println("Lỗi findByEmailAndPassword " + e.getLocalizedMessage());
        }
        return UserList;
    }
}