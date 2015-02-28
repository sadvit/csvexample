package com.sadvit.lab6.service;

import com.sadvit.lab6.dao.CustomerDAO;
import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.ui.util.Tabular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = false)
public class CustomerService extends AbstractService<Customer> {

	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		super(customerDAO);
	}

	public List<Tabular> getCustomerTabulars() {
		return getDaoProxy().readAll().stream().map(data -> (Tabular) data).collect(Collectors.toList());
	}

	public Customer read(Integer id) {
		return getDaoProxy().read(id);
	}

	public void save(Customer customer) {
		if (customer != null)
			if (customer.getId() == null) {
				getDaoProxy().create(customer);
			} else {
				getDaoProxy().update(customer);
			}
	}

	public void delete(Customer customer) {
		if (customer != null)
			getDaoProxy().delete(customer);
	}

	public void update(Customer customer) {
		if (customer != null && customer.getId() != null)
			getDaoProxy().update(customer);
	}

}
