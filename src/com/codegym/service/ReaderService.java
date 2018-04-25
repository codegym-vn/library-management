package com.codegym.service;

import com.codegym.model.Reader;
import java.sql.SQLException;
import java.util.List;

public interface ReaderService {
    List<Reader> findAll() throws ClassNotFoundException, SQLException;;

    boolean save(Reader reader) throws ClassNotFoundException, SQLException;;

    Reader findById(int id) throws ClassNotFoundException, SQLException;;

    boolean update(int id, Reader reader) throws ClassNotFoundException, SQLException;;

    boolean remove(int id) throws ClassNotFoundException, SQLException;;
}
