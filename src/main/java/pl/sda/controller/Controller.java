package pl.sda.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RENT on 2017-03-01.
 */
public interface Controller {
    void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
