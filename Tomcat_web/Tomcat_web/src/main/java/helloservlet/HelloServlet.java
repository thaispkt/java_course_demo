package helloservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    // GET, POST => Methods cách thức client gọi đường dẫn
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Sẽ thực  hiện khi người dùng query đường dẫn
        PrintWriter printwriter = resp.getWriter();
        printwriter.write("Hello Servlet world");
        printwriter.close();
    }
}
