package com.codegym.repository;

import com.codegym.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorMySqlRepository implements AuthorRepository {

    @Override
    public List<Author> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        List<Author> authors = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `authors`");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            Author author = new Author(id, name, description);
            authors.add(author);
        }
        connection.close();
        return authors;
    }

    @Override
    public boolean save(Author author) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `authors`(`name`, `description`) VALUES(?, ?)");
        System.out.println("Name: " + author.getName());
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getDescription());
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public Author findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `authors` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Author author = null;
        if (rs.next()){
            String name = rs.getString("name");
            String description = rs.getString("description");
            author = new Author(id, name, description);
        }
        connection.close();
        return author;
    }

    @Override
    public boolean update(int id, Author author) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `authors` SET `name`=?, `description`=? WHERE `id`=?");
        preparedStatement.setString(1, author.getName());
        preparedStatement.setString(2, author.getDescription());
        preparedStatement.setInt(3, id);

        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `authors` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }
}
