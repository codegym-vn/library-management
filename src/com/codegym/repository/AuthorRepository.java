package com.codegym.repository;

import com.codegym.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorRepository {
    List<Author> findAll() throws ClassNotFoundException, SQLException;

    boolean save(Author author) throws ClassNotFoundException, SQLException ;

    Author findById(int id) throws ClassNotFoundException, SQLException ;

    boolean update(int id, Author author) throws ClassNotFoundException, SQLException ;

    boolean remove(int id) throws ClassNotFoundException, SQLException ;
}
