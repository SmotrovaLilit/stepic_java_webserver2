package servlets;

import resourceServer.ResourceServer;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";

    private final ResourceServer resourceServer;

    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        try {
            resourceServer.updateTestResource(path);
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST_400);
            response.getWriter().print("Valid file");
            return;
        }

        response.getWriter().print("OK - "  + resourceServer.getTestResource().getName());
    }
}
