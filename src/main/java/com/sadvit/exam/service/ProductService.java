package com.sadvit.exam.service;

import com.sadvit.exam.dao.ProductDAO;
import com.sadvit.exam.domain.Product;
import com.sadvit.exam.ui.util.Tabular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = false)
public class ProductService extends AbstractService<Product> {

	@Autowired
	public ProductService(ProductDAO dao) {
		super(dao);
	}

	public Product getById(int id) {
		return getDaoProxy().load(id);
	}

	public List<Tabular> getProductTabulars() {
		List<Product> products = getDaoProxy().loadAll();
		return products.stream().map(data -> (Tabular) data).collect(Collectors.toList());
	}

	public void update(Product product) {
		getDaoProxy().update(product);
	}

	public void save(Product product) {
		getDaoProxy().save(product);
	}

	public void delete(Product product) {
		getDaoProxy().delete(product);
	}

}
