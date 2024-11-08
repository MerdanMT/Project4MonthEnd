package com.work4m.service;

import java.sql.SQLException;
import java.util.List;

public interface CommonService<T> {

    T add(T entity) throws SQLException;

    T update(Integer id,T entity) throws SQLException;

    Integer delete(Integer id) throws SQLException;

    T getById(Integer id) throws SQLException;

    List<T> getAll() throws SQLException;
}
