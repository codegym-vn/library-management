package com.codegym.repository;

import com.codegym.model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderMySqlRepository implements ReaderRepository {

    @Override
    public List<Reader> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        List<Reader> readers = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `readers`");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String avatar = rs.getString("avatar");
            Reader reader = new Reader(id, name, email, address, phone, avatar);
            readers.add(reader);
        }
        connection.close();
        return readers;
    }

    @Override
    public boolean save(Reader reader) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `readers`(`name`, `email`, `address`, `phone`, `avatar`) VALUES(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, reader.getName());
        preparedStatement.setString(2, reader.getEmail());
        preparedStatement.setString(3, reader.getAddress());
        preparedStatement.setString(4, reader.getPhone());
        preparedStatement.setString(5, reader.getAvatar());
        int affectedRows = preparedStatement.executeUpdate();
        connection.close();
        return affectedRows > 0;
    }

    @Override
    public Reader findById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `readers` WHERE `id`=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Reader reader = null;
        if (rs.next()){
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String phone = rs.getString("name");
            String avatar = rs.getString("avatar");
            reader = new Reader(id, name, email, address, phone, avatar);
        }
        connection.close();
        return reader;
    }

    @Override
    public boolean update(int id, Reader reader) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `readers` SET `name`=?, `email`=?, `address`=?, `phone`=?, `avatar`=? WHERE `id`=?");
        preparedStatement.setString(1, reader.getName());
        preparedStatement.setString(2, reader.getEmail());
        preparedStatement.setString(3, reader.getAddress());
        preparedStatement.setString(4, reader.getPhone());
        preparedStatement.setString(5, reader.getAvatar());
        preparedStatement.setInt(6, id);

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
