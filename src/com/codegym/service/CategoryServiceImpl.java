package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.CategoryMySqlRepository;
import com.codegym.repository.CategoryRepository;
import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository = new CategoryMySqlRepository();

    @Override
    public List<Category> findAll() throws SQLException, ClassNotFoundException {
        return this.categoryRepository.findAll();
    }

    @Override
    public boolean save(Category category) throws SQLException, ClassNotFoundException {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) throws SQLException, ClassNotFoundException {
        return this.categoryRepository.findById(id);
    }

    @Override
    public boolean update(int id, Category category) throws SQLException, ClassNotFoundException {
        return this.categoryRepository.update(id, category);
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        return this.categoryRepository.remove(id);
    }
}
