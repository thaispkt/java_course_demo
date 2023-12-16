// RoleController.java
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "roleController", urlPatterns = {"/role", "/role-add", "/role-delete"})
public class RoleController extends HttpServlet {
    private RoleService roleService = new RoleService();
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        logger.info("Request Path: {}", path);
        if (path.equals("/role")) {
            logger.info("Calling doGetRoleTable(req,resp)");
            doGetRoleTable(req, resp);
        } else if (path.equals("/role-add")) {
            doGetRoleAdd(req, resp);
        } else if (path.equals("/role-delete")) {
            doGetRoleDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPostRoleAdd(req, resp);
    }

    private void doGetRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Entering doGetRoleAdd(req, resp)");
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }

    private void doGetRoleTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("roleList = roleService.getAllRoles()");
        List<RoleEntity> roleList = roleService.getAllRoles();
        for (RoleEntity role : roleList) {
            logger.info("Iterating role : roleList");
            logger.info("role_name = role.getName() = {}", role.getName());
        }
        req.setAttribute("listRole", roleList);
        req.getRequestDispatcher("role-table.jsp").forward(req, resp);
    }

    private void doPostRoleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Entering doPostRoleAdd(req, resp)");
        String roleName = req.getParameter("role-name");
        String roleDescription = req.getParameter("role-description");
        boolean isSuccess = roleService.addRole(roleName, roleDescription);
        logger.info("Add role result: {}", isSuccess);
        req.getRequestDispatcher("role-add.jsp").forward(req, resp);
    }

    private void doGetRoleDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Entering doGetRoleDelete(req, resp)");
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = roleService.deleteRole(id);
        logger.info("Delete role result: {}", isSuccess);
        resp.sendRedirect(req.getContextPath() + "/role");
    }
}
