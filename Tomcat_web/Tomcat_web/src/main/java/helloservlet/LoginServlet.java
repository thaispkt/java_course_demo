package helloservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    // GET, POST => Methods cách thức HTTP client gọi đường dẫn

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		super.doGet(req, resp);
        //Hiển thị nọi dug file html khi người dùng gọi link/login
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("Debug POST: email = " + email);
        System.out.println("Debug POST: password = " + password);
        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}