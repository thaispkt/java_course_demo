package controller;

import entity.RoleEntity;
import services.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
// Sau khi code Role controller -> chuyen sang Role service de viet function
//@WebServlet(name="roleController",urlPatterns = "/role-add")
@WebServlet(name="roleController",urlPatterns = {"/role","/role-add","/role-delete" })
public class RoleController extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println("Check: " + path);
        if (path.equals("/role")) {
            doGetRoleTable(req,resp);
        } else if (path.equals("/role-add")) {
            doGetRoleAdd(req,resp);
        } else if (path.equals("/role-delete")) {
            doGetRoleDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPostRoleAdd(req,resp);
    }

    private void doGetRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }
    private void doGetRoleTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> roleList = roleService.getAllRoles();
        req.setAttribute("listRole",roleList);
        req.getRequestDispatcher("role-table.jsp").forward(req,resp);
    }
    private void doPostRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String roleName = req.getParameter("role-name");
        String roleDescription = req.getParameter("role-description");
        boolean isSuccess = roleService.addRole(roleName, roleDescription);
        System.out.println("Add role result: " + isSuccess);
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }
    private void doGetRoleDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = roleService.deleteRole(id);
        System.out.println("Delete role result: " + isSuccess);
        resp.sendRedirect(req.getContextPath() + "/role"); // khi mình xóa page thì chuyển sang
        // trang role
    }
}