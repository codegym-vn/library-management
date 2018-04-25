package com.codegym.service;

import com.codegym.model.Reader;
import com.codegym.repository.ReaderMySqlRepository;
import com.codegym.repository.ReaderRepository;

import java.sql.SQLException;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    private ReaderRepository readerRepository = new ReaderMySqlRepository();

    @Override
    public List<Reader> findAll() throws SQLException, ClassNotFoundException {
        return this.readerRepository.findAll();
    }

    @Override
    public boolean save(Reader reader) throws SQLException, ClassNotFoundException {
        return this.readerRepository.save(reader);
    }

    @Override
    public Reader findById(int id) throws SQLException, ClassNotFoundException {
        return this.readerRepository.findById(id);
    }

    @Override
    public boolean update(int id, Reader reader) throws SQLException, ClassNotFoundException {
        return this.readerRepository.update(id, reader);
    }

    @Override
    public boolean remove(int id) throws SQLException, ClassNotFoundException {
        return this.readerRepository.remove(id);
    }
}
