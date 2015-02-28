package com.sadvit.lab6.dao.impl;

import com.sadvit.lab6.dao.AbstractDAO;
import com.sadvit.lab6.dao.SaleDAO;
import com.sadvit.lab6.domain.Sale;

import java.util.List;

public class SaleDAOImpl extends AbstractDAO<Sale> implements SaleDAO {

	@Override
	public List<Sale> readAll() {
		return getTemplate().loadAll(Sale.class);
	}

	@Override
	public Sale read(int id) {
		return getTemplate().get(Sale.class, id);
	}
}
