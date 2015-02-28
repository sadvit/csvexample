package com.sadvit.lab6.ui.viewer;

import java.util.List;

import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.domain.Sale;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractModel;
import com.sadvit.lab6.ui.util.Tabular;

public class SaleModel extends AbstractModel {
	
	private Sale currentSale;
	
	private Customer currentCustomer;
	
	private Product currentProduct;
	
	public Sale createEmptySale() {
		Sale sale = new Sale();
		saleService.save(sale);
		return sale;
	}
	
	public void updateCurrentSale(Sale newSale) {
		currentSale.setCount(newSale.getCount());
		currentSale.setCustomerId(newSale.getCustomerId());
		currentSale.setDate(newSale.getDate());
		currentSale.setProductId(newSale.getProductId());
		currentSale.setSeat(newSale.getSeat());
		saleService.update(currentSale);
	}
	
	public void deleteCurrentSale() {
		if (currentSale != null) {
			saleService.delete(currentSale);
			currentSale = null;
		}
	}
	
	public Sale getCurrentSale() {
		return currentSale;
	}

	public void setCurrentSale(Sale currentSale) {
		this.currentSale = currentSale;
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}

	public Sale getSale(int id) {
		return saleService.read(id);
	}
	
	public List<Tabular> getCustomers() {
		return customerService.getCustomerTabulars();
	}
	
	public List<Tabular> getProducts() {
		return productService.getProductTabulars();
	}

}
