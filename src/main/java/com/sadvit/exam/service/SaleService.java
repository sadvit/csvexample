package com.sadvit.exam.service;

import com.sadvit.exam.dao.SaleDAO;
import com.sadvit.exam.domain.Sale;
import com.sadvit.exam.ui.util.Tabular;
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
		return getDaoProxy().load(id);
	}

	public void save(Sale sale) {
		getDaoProxy().save(sale);
	}

	public List<Tabular> getSaleTabulars() {
		return getDaoProxy().loadAll().stream().map(data -> (Tabular) data).collect(Collectors.toList());
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
