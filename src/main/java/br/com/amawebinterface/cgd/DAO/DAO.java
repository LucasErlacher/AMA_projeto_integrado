package br.com.amawebinterface.cgd.DAO;

import java.util.List;

public interface DAO<T> {

    public void insert(T obj);

    public void update(T obj);

    public void delete(T obj);

    public T findbyID(Long id);

    public List<T> findAll();
}
