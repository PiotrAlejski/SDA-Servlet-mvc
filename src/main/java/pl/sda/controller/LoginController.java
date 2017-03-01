package pl.sda.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RENT on 2017-03-01.
 */
public class LoginController implements Controller {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Hello LoginContoller</h1>");
        writer.write("<nul>");
        for (int i = 0; i < cookies.length; i++) {
            writer.write("<li>" + cookies[i].getName() + " : " + cookies[i].getValue() + "</li>");
        }
        writer.write("</ul>");
        Cookie helloCookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("hello")) {
                Cookie cookie = cookies[i];
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
