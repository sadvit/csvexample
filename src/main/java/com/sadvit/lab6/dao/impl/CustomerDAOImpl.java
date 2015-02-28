package com.sadvit.lab6.dao.impl;

import com.sadvit.lab6.dao.AbstractDAO;
import com.sadvit.lab6.dao.CustomerDAO;
import com.sadvit.lab6.domain.Customer;

import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> readAll() {
		return getTemplate().loadAll(Customer.class);
	}

	@Override
	public Customer read(int id) {
		return getTemplate().get(Customer.class, id);
	}
}
