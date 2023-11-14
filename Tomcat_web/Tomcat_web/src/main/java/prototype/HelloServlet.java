package prototype;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    /*
        Nhận parameter từ HTTP client gửi lên
        - Giữa GET và POST cách nhận parameter sẽ giống nhau
        - GET: Parameter sẽ truyền trực tiếp trên URL
        - POST: Parameter sẽ truyền qua thẻ FORM của HTML hoặc application, code gọi link với phương
        thức POST (Parameter sẽ được truyền ngầm)
     */
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sẽ thực  hiện khi người dùng query đường dẫn
        PrintWriter printwriter = resp.getWriter();
        printwriter.write("Hello Servlet world");
        printwriter.close();
        // Lấy giá trị của tham số có tên là username và age
        String username = req.getParameter("username");
//        int age = Integer.parseInt(req.getParameter("age"));
//        System.out.println("Debug: username = "+ username);
//        System.out.println("Debug: age = "+ age);
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }
}
