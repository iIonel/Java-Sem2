package org.example;
import java.sql.*;
import java.util.*;
public abstract class DAO<T> {
    public abstract void create(String artist) throws SQLException;
    public abstract String findById(int id) throws SQLException;
    public abstract List<T> findAll() throws SQLException;
    public abstract Integer findByName(String name);
}
