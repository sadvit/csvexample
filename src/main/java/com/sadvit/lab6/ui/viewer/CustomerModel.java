package com.sadvit.lab6.ui.viewer;

import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractModel;

public class CustomerModel extends AbstractModel {
	
	private Customer currentCustomer;
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public Customer createEmptyCustomer() {
		Customer customer = new Customer();
		customer.setName("empty");
		customerService.save(customer);
		return customer;
	}
	
	public void deleteCurrentCustomer() {
		if (currentCustomer != null) {
			customerService.delete(currentCustomer);
			currentCustomer = null;
		}
	}
	
	public void updateCurrentCustomer(Customer newCustomer) {
		currentCustomer.setName(newCustomer.getName());
		currentCustomer.setAddress(newCustomer.getAddress());
		currentCustomer.setSeat(newCustomer.getSeat());
		customerService.update(currentCustomer);
	}
	
	public Customer getCustomer(int id) {
		return customerService.read(id);
	}

}
