package com.example.finalTryJDBC.demo.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    //generic interface rkhlo (good practice).
    //if there is something that could be possible or not possible on runTime , take it as Optional.

    List<T> list();
    void create(T t);
    Optional<T> get(int id);
    void update(T t , int id);
    void delete(int id);
    void createTable();
}
