package com.sadvit.lab6.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class AbstractDAO<T> implements DAO<T> {

	@Autowired
	private HibernateTemplate template;

	protected HibernateTemplate getTemplate() {
		return template;
	}

	@Override
	public void create(T object) {
		template.save(object);
	}

	@Override
	public void update(T object) {
		template.update(object);
	}

	@Override
	public void delete(T object) {
		template.delete(object);
	}

}
