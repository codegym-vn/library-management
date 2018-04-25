package com.codegym.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {
    protected void showInternalError(Exception exception, HttpServletRequest request, HttpServletResponse response){
        try {
            exception.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("error-500.jsp");
            request.setAttribute("message", exception.getMessage());
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
