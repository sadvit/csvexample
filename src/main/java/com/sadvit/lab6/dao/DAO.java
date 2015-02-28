package com.sadvit.lab6.dao;

import java.util.List;

public interface DAO<T> {
	
    void create(T object);

    T read(int id);

    List<T> readAll();

    void update(T object);

    void delete(T object);

}
