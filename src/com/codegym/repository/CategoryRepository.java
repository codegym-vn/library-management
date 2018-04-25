package com.codegym.repository;

import com.codegym.model.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryRepository {
    List<Category> findAll() throws ClassNotFoundException, SQLException;

    boolean save(Category category) throws ClassNotFoundException, SQLException ;

    Category findById(int id) throws ClassNotFoundException, SQLException ;

    boolean update(int id, Category category) throws ClassNotFoundException, SQLException ;

    boolean remove(int id) throws ClassNotFoundException, SQLException ;
}
