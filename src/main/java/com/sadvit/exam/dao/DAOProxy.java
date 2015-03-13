package com.sadvit.exam.dao;

import com.sadvit.exam.service.MapStorage;
import com.sadvit.exam.service.Storeable;

import java.util.List;

public class DAOProxy<T extends Storeable> implements DAO<T> {

    private MapStorage<T> storage = new MapStorage<>();

    private DAO<T> dao;

    public DAOProxy(DAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public void save(T object) {
        dao.save(object);
        storage.setValue(object);
    }

    @Override
    public T load(Integer id) {
        T object = storage.getValue(id);
        if (object == null) {
            T entity = dao.load(id);
            storage.setValue(entity);
            return entity;
        } else {
            return object;
        }
    }

    @Override
    public List<T> loadAll() {
        if (storage.isEmpty()) {
            List<T> objects = dao.loadAll();
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
