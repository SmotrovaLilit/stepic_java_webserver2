package servlets;

import accountServer.AccountServer;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {
    public static final String PAGE_URL = "/admin";

    private final AccountServer accountServer;

    public AdminServlet(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpStatus.OK_200);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(accountServer.getUsersLimit());
    }
}
