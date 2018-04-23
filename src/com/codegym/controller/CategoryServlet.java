package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import com.codegym.service.CategoryServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryServlet extends HttpServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCategory(request, response);
                break;
            case "edit":
                updateCategory(request, response);
                break;
            case "delete":
                deleteCategory(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCategory(request, response);
                break;
            default:
                listCategories(request, response);
                break;
        }
    }

    private void viewCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = this.categoryService.findById(id);
            RequestDispatcher dispatcher;
            if(category == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("category", category);
                dispatcher = request.getRequestDispatcher("category/view.jsp");
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = this.categoryService.findById(id);
            RequestDispatcher dispatcher;
            if(category == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                this.categoryService.remove(id);
                response.sendRedirect("/categories");
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = this.categoryService.findById(id);
            RequestDispatcher dispatcher;
            if(category == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("category", category);
                dispatcher = request.getRequestDispatcher("category/delete.jsp");
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Category category = this.categoryService.findById(id);
            RequestDispatcher dispatcher;
            if(category == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                category.setName(name);
                this.categoryService.update(id, category);
                request.setAttribute("category", category);
                request.setAttribute("message", "Category information was updated");
                dispatcher = request.getRequestDispatcher("category/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = this.categoryService.findById(id);
            RequestDispatcher dispatcher;
            if(category == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("category", category);
                dispatcher = request.getRequestDispatcher("category/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int id = (int)(Math.random() * 10000);

            Category category = new Category(id, name);
            this.categoryService.save(category);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
            request.setAttribute("message", "New category was created");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categories = this.categoryService.findAll();
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }
    private void showInternalError(Exception exception, HttpServletRequest request, HttpServletResponse response){
        try {
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
