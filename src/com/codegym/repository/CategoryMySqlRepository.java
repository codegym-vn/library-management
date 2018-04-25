package com.codegym.repository;

import com.codegym.model.Category;

import java.sql.*;
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
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `categories`(`name`) VALUES(?)");
        preparedStatement.setString(1, category.getName());
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public Category findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `categories` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
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
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `categories` SET `name`=? WHERE `id`=?");
        preparedStatement.setString(1, category.getName());
        preparedStatement.setInt(2, id);
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `categories` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }
}
