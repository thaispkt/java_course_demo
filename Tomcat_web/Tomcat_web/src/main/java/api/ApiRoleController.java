package api;

import com.google.gson.Gson;
import payload.BasicResponse;
import services.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiRoleController", urlPatterns = {"/api/role"})
public class ApiRoleController extends HttpServlet {
    private RoleService roleService = new RoleService();
    private Gson gson = new Gson();
    /*
    {
    "statusCode": 200,
    "message": ""
    "data": true => dynamic data type
    payload: request, response
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test DELETE");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id = " + id);
        boolean isSuccess = roleService.deleteRole(id);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setStatusCode(200);
        basicResponse.setMessage("");
        basicResponse.setData(isSuccess);
        String dataJSON = gson.toJson(basicResponse);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        out.print(dataJSON);
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Do Servlet chưa support subpat /role/1 (DELETE) nên ta dùng parameter. Nếu muốn dùng
        // subpath thì phải tự parse trong Servlet
        System.out.println("Test GET");
    }
}
