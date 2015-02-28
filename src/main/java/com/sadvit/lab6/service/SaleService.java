package com.sadvit.lab6.service;

import com.sadvit.lab6.dao.SaleDAO;
import com.sadvit.lab6.domain.Sale;
import com.sadvit.lab6.ui.util.Tabular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = false)
public class SaleService extends AbstractService<Sale> {

	@Autowired
	public SaleService(SaleDAO daoBasic) {
		super(daoBasic);
	}

	public Sale read(Integer id) {
		return getDaoProxy().read(id);
	}

	public void save(Sale sale) {
		getDaoProxy().create(sale);
	}

	public List<Tabular> getSaleTabulars() {
		return getDaoProxy().readAll().stream().map(data -> (Tabular) data).collect(Collectors.toList());
	}

	public void update(Sale sale) {
		if (sale != null && sale.getId() != null)
			getDaoProxy().update(sale);
	}

	public void delete(Sale sale) {
		if (sale != null)
			getDaoProxy().delete(sale);
	}

}
