package com.codegym.service;

import com.codegym.model.Author;
import com.codegym.repository.AuthorMySqlRepository;
import com.codegym.repository.AuthorRepository;

import java.sql.SQLException;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository = new AuthorMySqlRepository();

    @Override
    public List<Author> findAll() throws ClassNotFoundException, SQLException {
        return this.authorRepository.findAll();
    }

    @Override
    public boolean save(Author author) throws ClassNotFoundException, SQLException {
        return this.authorRepository.save(author);
    }

    @Override
    public Author findById(int id) throws ClassNotFoundException, SQLException {
        return this.authorRepository.findById(id);
    }

    @Override
    public boolean update(int id, Author author) throws ClassNotFoundException, SQLException {
        return this.authorRepository.update(id, author);
    }

    @Override
    public boolean remove(int id) throws ClassNotFoundException, SQLException {
        return this.authorRepository.remove(id);
    }
}
