package MySQLConfig;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConfig {
    public static Connection getConnection() {
        // Khai báo driver sử dụng cho JDBC (từ khóa tên driver class.forname)
        // VD: JDBC MySQL class.forname
        try {
            // Khai báo dr
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Khai báo thông tin CSDL mà JDBC sẽ connect tới
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/CRM_app","root",
                    "admin123");
        } catch (Exception e) {
            System.out.println("MySQL database connection error " + e.getLocalizedMessage());
//            throw new RuntimeException(e);
        }
        return null;
    }
}
