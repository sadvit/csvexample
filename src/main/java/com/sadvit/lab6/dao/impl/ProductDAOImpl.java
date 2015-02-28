package com.sadvit.lab6.dao.impl;

import com.sadvit.lab6.dao.AbstractDAO;
import com.sadvit.lab6.dao.ProductDAO;
import com.sadvit.lab6.domain.Product;

import java.util.List;

public class ProductDAOImpl extends AbstractDAO<Product> implements ProductDAO {

	@Override
	public List<Product> readAll() {
		return getTemplate().loadAll(Product.class);
	}

	@Override
	public Product read(int id) {
		return getTemplate().get(Product.class, id);
	}
}
