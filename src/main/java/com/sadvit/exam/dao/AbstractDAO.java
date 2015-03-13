package com.sadvit.exam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

//@Repository No qualifying bean of type found for dependency
//@Transactional(readOnly = false)
public abstract class AbstractDAO<T> implements DAO<T> {

	@Autowired
	private HibernateTemplate hibernateTemplate;

    private Class<T> clazz;

    public void save(T object) {
        getHibernateTemplate().save(object);
    }

    public void update(T object) {
        getHibernateTemplate().update(object);
    }

    public void delete(T object) {
        getHibernateTemplate().delete(object);
    }

    public T load(Integer id) {
        return getHibernateTemplate().load(clazz, id);
    }

    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(clazz);
    }

	protected HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

}
