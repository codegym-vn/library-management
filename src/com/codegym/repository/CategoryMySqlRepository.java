package com.codegym.repository;

import com.codegym.model.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryMySqlRepository implements CategoryRepository {

    @Override
    public List<Category> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        List<Category> categories = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `categories`");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category cate = new Category(id, name);
            categories.add(cate);
        }
        connection.close();
        return categories;
    }

    @Override
    public boolean save(Category category) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        Statement stmt = connection.createStatement();
        int affectedRows = stmt.executeUpdate("INSERT INTO `categories`(`name`) VALUES('" + category.getName() + "')");
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public Category findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `categories` WHERE `id`=" + id);
        Category category = null;
        if (rs.next()){
            String name = rs.getString("name");
            category = new Category(id, name);
        }
        connection.close();
        return category;
    }

    @Override
    public boolean update(int id, Category category) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        Statement stmt = connection.createStatement();
        int affectedRows = stmt.executeUpdate("UPDATE `categories` SET " +
                "`name`='" + category.getName() + "'" +
                " WHERE `id`=" + id);
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        Statement stmt = connection.createStatement();
        int affectedRows = stmt.executeUpdate("DELETE FROM `categories` WHERE `id`=" + id);
        connection.close();
        return affectedRows > 0;
    }
}
