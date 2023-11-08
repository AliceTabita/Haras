package br.com.haras.model.dao;

import java.util.List;

public interface IDao<T> {
    void save(T obj);
    void update(T obj);
    boolean delete(T obj);
    T find(int id);
    List<T> findAll();

}
