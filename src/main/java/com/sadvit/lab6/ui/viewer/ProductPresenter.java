package com.sadvit.lab6.ui.viewer;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractEditor;
import com.sadvit.lab6.ui.mvp.skeleton.EditorPresenter;


public class ProductPresenter extends AbstractEditor implements EditorPresenter<ProductModel, Node, Product> {
	
	private ProductModel model; 

	@FXML 
	TextField name;
	
	@FXML 
	TextField number;
	
	@FXML 
	DatePicker date;

	@Override
	public void clear() {
		name.setText("");
		number.setText("");
		date.setValue(null);
	}

	@Override
	public void updateHandler() {
		Product actual = getContent();
		if (actual != null)
			getModel().updateCurrentProduct(actual);
	}

	@Override
	public void createHandler() {
		getModel().createEmptyProduct();
	}

	@Override
	public void deleteHandler() {
		clear();
		getModel().deleteCurrentProduct();
	}

	@Override
	public ProductModel getModel() {
		return model;
	}

	@Override
	public void setModel(ProductModel model) {
		this.model = model;		
	}

	@Override
	public void setContent(Product product) {
		if (product == null) {
			clear();
			return;
		}
		name.setText(product.getName());
		number.setText(String.valueOf(product.getNumber()));
		date.setValue(product.getDate());		
	}

	@Override
	public Product getContent() {
		System.out.println(date.getValue());
		try {
			return new Product(name.getText(), Integer.parseInt(number.getText()), date.getValue());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void withdraw(int id) {
		Product product = getModel().getProduct(id);
		getModel().setCurrentProduct(product);
		setContent(product);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}	

}
