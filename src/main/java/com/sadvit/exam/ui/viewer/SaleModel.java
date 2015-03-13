package com.sadvit.exam.ui.viewer;

import com.sadvit.exam.domain.Customer;
import com.sadvit.exam.domain.Product;
import com.sadvit.exam.domain.Sale;
import com.sadvit.exam.ui.mvp.skeleton.AbstractModel;
import com.sadvit.exam.ui.util.Tabular;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
