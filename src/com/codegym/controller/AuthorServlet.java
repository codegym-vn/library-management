package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.service.AuthorService;
import com.codegym.service.AuthorServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AuthorServlet", urlPatterns = "/authors")
@MultipartConfig
public class AuthorServlet extends BaseServlet {

    private AuthorService authorService = new AuthorServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createAuthor(request, response);
                break;
            case "edit":
                updateAuthor(request, response);
                break;
            case "delete":
                deleteAuthor(request, response);
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
                viewAuthor(request, response);
                break;
            default:
                listAuthors(request, response);
                break;
        }
    }

    private void viewAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Author author = this.authorService.findById(id);
            RequestDispatcher dispatcher;
            if(author == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("author", author);
                dispatcher = request.getRequestDispatcher("author/view.jsp");
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Author author = this.authorService.findById(id);
            RequestDispatcher dispatcher;
            if(author == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                this.authorService.remove(id);
                response.sendRedirect("/authors");
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Author author = this.authorService.findById(id);
            RequestDispatcher dispatcher;
            if(author == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("author", author);
                dispatcher = request.getRequestDispatcher("author/delete.jsp");
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void updateAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Author author = this.authorService.findById(id);
            RequestDispatcher dispatcher;
            if(author == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                author.setName(name);
                author.setDescription(description);
                this.authorService.update(id, author);
                request.setAttribute("author", author);
                request.setAttribute("message", "Author information was updated");
                dispatcher = request.getRequestDispatcher("author/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Author author = this.authorService.findById(id);
            RequestDispatcher dispatcher;
            if(author == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("author", author);
                dispatcher = request.getRequestDispatcher("author/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void createAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Author author = new Author(name, description);
            this.authorService.save(author);
            RequestDispatcher dispatcher = request.getRequestDispatcher("author/create.jsp");
            request.setAttribute("message", "New author was created");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("author/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAuthors(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Author> authors = this.authorService.findAll();
            request.setAttribute("authors", authors);
            RequestDispatcher dispatcher = request.getRequestDispatcher("author/list.jsp");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }
}
