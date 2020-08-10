package com.revature.dao;

import java.sql.SQLException;
import java.util.Set;

public interface CrudRepository {

    Object save(Object t) throws SQLException;

    Set<Object> findAll() throws SQLException;

    Object findById(int id) throws SQLException;

    boolean update(Object t) throws SQLException;

    boolean deleteById(int id) throws SQLException;
}