package com.sadvit.lab6.ui.viewer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractEditor;
import com.sadvit.lab6.ui.mvp.skeleton.EditorPresenter;

public class CustomerPresenter extends AbstractEditor implements EditorPresenter<CustomerModel, Node, Customer> {
	
	private CustomerModel model;
	
	@FXML 
	TextField name;

	@FXML 
	TextField address;

	@FXML 
	TextField sale;

	@Override
	public CustomerModel getModel() {
		return model;
	}

	@Override
	public void setModel(CustomerModel model) {
		this.model = model;
	}

	@Override
	public void clear() {
		name.setText("");
		address.setText("");
		sale.setText("");
	}

	public void setContent(Customer customer) {
		if (customer == null) {
			clear();
			return;
		}
		name.setText(customer.getName());
		address.setText(customer.getAddress());
		sale.setText(String.valueOf(customer.getSeat()));
	}

	@Override
	public Customer getContent() {
		try {
			return new Customer(name.getText(), address.getText(), Integer.parseInt(sale.getText()));
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public void updateHandler() {
		Customer actual = getContent();
		if (actual != null)
			getModel().updateCurrentCustomer(actual);
	}

	@Override
	public void createHandler() {
		getModel().createEmptyCustomer();
	}

	@Override
	public void deleteHandler() {
		clear();
		getModel().deleteCurrentCustomer();
	}

	@Override
	public void withdraw(int id) {
		Customer customer = getModel().getCustomer(id);
		getModel().setCurrentCustomer(customer);
		setContent(customer);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}