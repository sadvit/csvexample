package com.sadvit.exam.dao;

import java.util.List;

public interface DAO<T> {

    public void save(T object);

    public void update(T object);

    public void delete(T object);

    public T load(Integer id);

    public List<T> loadAll();

}
