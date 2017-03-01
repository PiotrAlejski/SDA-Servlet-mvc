package pl.sda.servlet;

import org.apache.commons.lang3.StringUtils;
import pl.sda.controller.Controller;
import pl.sda.controller.CookieController;
import pl.sda.controller.LoginController;
import pl.sda.controller.UserController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-03-01.
 */
public class HelloServlet extends HttpServlet {
    private Map<String, Controller> controllerMap;


    @Override
    public void init() throws ServletException {
        this.controllerMap = new HashMap<String, Controller>();
        controllerMap.put("users", new UserController());
        controllerMap.put("login", new LoginController());
        controllerMap.put("cookie", new CookieController());
        controllerMap.put("default", (request, response) -> response.getWriter()
                .write("<h1>Hello from defoult controller</h1>"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String requestURI = req.getRequestURI();
        String relativePath = requestURI.substring(StringUtils.ordinalIndexOf(requestURI, "/", 2) + 1);
        Controller controller = controllerMap.get(relativePath);
        if (controller == null) {
            controller = controllerMap.get("default");
        }
        controller.handleGet(req, resp);
    }
}
