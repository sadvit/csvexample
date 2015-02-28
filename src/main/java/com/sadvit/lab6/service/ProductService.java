package com.sadvit.lab6.service;

import com.sadvit.lab6.dao.ProductDAO;
import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.ui.util.Tabular;
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
		return getDaoProxy().read(id);
	}

	public List<Tabular> getProductTabulars() {
		List<Product> products = getDaoProxy().readAll();
		return products.stream().map(data -> (Tabular) data).collect(Collectors.toList());
	}

	public void update(Product product) {
		getDaoProxy().update(product);
	}

	public void save(Product product) {
		getDaoProxy().create(product);
	}

	public void delete(Product product) {
		getDaoProxy().delete(product);
	}

}
