package controller;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@WebServlet("/accounts/*")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Gson gson = new Gson();
    private HashMap<String, Account> accountsDb = new HashMap<>();

    class Account {
        public String id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;

        public Account(String _id, String _email, String _first_name, String _last_name, String _avatar) {
            id = _id;
            email = _email;
            first_name = _first_name;
            last_name = _last_name;
            avatar = _avatar;
        }
    }

    public AccountController() {
        super();
        // Initialize with some accounts
        // In a real application, this would be replaced with database initialization
        accountsDb.put("1", new Account("1", "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"));
        accountsDb.put("2", new Account("2", "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"));
        accountsDb.put("3", new Account("3", "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"));
        accountsDb.put("4", new Account("4", "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"));
        accountsDb.put("5", new Account("5", "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"));
        accountsDb.put("6", new Account("6", "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg"));
        // Add more accounts as needed
    }

    private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(obj));
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            Collection<Account> accounts = accountsDb.values();
            sendAsJson(resp, accounts);
        } else {
            String[] splits = pathInfo.split("/");
            if (splits.length != 2) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            String accountId = splits[1];
            Account account = accountsDb.get(accountId);
            if (account == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            sendAsJson(resp, account);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String payload = buffer.toString();
        Account account = gson.fromJson(payload, Account.class);
        account.id = UUID.randomUUID().toString();
        accountsDb.put(account.id, account);
        sendAsJson(resp, account);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String[] splits = pathInfo.split("/");

        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String accountId = splits[1];

        if (!accountsDb.containsKey(accountId)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        String payload = buffer.toString();
        Account updatedAccount = gson.fromJson(payload, Account.class);

        accountsDb.put(accountId, updatedAccount);
        sendAsJson(response, updatedAccount);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String[] splits = pathInfo.split("/");

        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        String accountId = splits[1];

        if (!accountsDb.containsKey(accountId)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Account removedAccount = accountsDb.remove(accountId);
        sendAsJson(response, removedAccount);
    }

}
