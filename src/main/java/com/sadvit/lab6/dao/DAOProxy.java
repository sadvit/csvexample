package com.sadvit.lab6.dao;


import com.sadvit.lab6.service.MapStorage;
import com.sadvit.lab6.service.Storeable;

import java.util.List;

/**
 * С помощью этого прокси объекта была исправлена проблема массы шаблонного кода
 * в сервисах при использовании map - storage.
 */
public class DAOProxy<T extends Storeable> implements DAO<T> {

    private MapStorage<T> storage = new MapStorage<>();

    private DAO<T> dao;

    public DAOProxy(DAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public void create(T object) {
        dao.create(object);
        storage.setValue(object);
    }

    @Override
    public T read(int id) {
        T object = storage.getValue(id);
        if (object == null) {
            T entity = dao.read(id);
            storage.setValue(entity);
            return entity;
        } else {
            return object;
        }
    }

    @Override
    public List<T> readAll() {
        if (storage.isEmpty()) {
            List<T> objects = dao.readAll();
            storage.setValues(objects);
            return objects;
        } else {
            return storage.getValues();
        }
    }

    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Override
    public void delete(T object) {
        dao.delete(object);
        storage.delete(object);
    }
}
