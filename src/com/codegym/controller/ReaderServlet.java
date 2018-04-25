package com.codegym.controller;

import com.codegym.model.Reader;
import com.codegym.service.ReaderService;
import com.codegym.service.ReaderServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReaderServlet", urlPatterns = "/readers")
@MultipartConfig
public class ReaderServlet extends BaseServlet {

    private ReaderService readerService = new ReaderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createReader(request, response);
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
            Reader reader = this.readerService.findById(id);
            RequestDispatcher dispatcher;
            if(reader == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("reader", reader);
                dispatcher = request.getRequestDispatcher("reader/view.jsp");
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void deleteAuthor(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reader reader = this.readerService.findById(id);
            RequestDispatcher dispatcher;
            if(reader == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                this.readerService.remove(id);
                response.sendRedirect("/readers");
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reader reader = this.readerService.findById(id);
            RequestDispatcher dispatcher;
            if(reader == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("reader", reader);
                dispatcher = request.getRequestDispatcher("reader/delete.jsp");
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
            Reader reader = this.readerService.findById(id);
            RequestDispatcher dispatcher;
            if(reader == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                reader.setName(name);
                this.readerService.update(id, reader);
                request.setAttribute("reader", reader);
                request.setAttribute("message", "Author information was updated");
                dispatcher = request.getRequestDispatcher("reader/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reader reader = this.readerService.findById(id);
            RequestDispatcher dispatcher;
            if(reader == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("reader", reader);
                dispatcher = request.getRequestDispatcher("reader/edit.jsp");
            }
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void createReader(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            Part avatarPart = request.getPart("avatar");
            String avatarFileName = Paths.get(avatarPart.getSubmittedFileName()).getFileName().toString();
            saveAvatarFile(avatarPart, avatarFileName);
            Reader reader = new Reader(name, email, address, phone, avatarFileName);
            this.readerService.save(reader);
            RequestDispatcher dispatcher = request.getRequestDispatcher("reader/create.jsp");
            request.setAttribute("message", "New reader was created");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }

    private void saveAvatarFile(Part avatarPart, String name) throws IOException {
//        String path = getServletContext().getRealPath("images/" + name);
        String path = "/Users/nhat/Desktop/abc/" +  name;

        avatarPart.write(path);
//        BufferedInputStream bis = new BufferedInputStream(avatarPart.getInputStream());
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
//        byte[] buf = new byte[1024];
//        int length = 0;
//        while (bis.read(buf, 0, 1024) > 0){
//            bos.write(buf, 0, length);
//        }
//        bis.close();
//        bos.close();
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("reader/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAuthors(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Reader> readers = this.readerService.findAll();
            request.setAttribute("readers", readers);
            RequestDispatcher dispatcher = request.getRequestDispatcher("reader/list.jsp");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            showInternalError(e, request, response);
        }
    }
}
