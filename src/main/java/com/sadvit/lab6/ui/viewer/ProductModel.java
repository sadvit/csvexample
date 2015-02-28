package com.sadvit.lab6.ui.viewer;

import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractModel;

public class ProductModel extends AbstractModel {
	
	private Product currentProduct;

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}
	
	public Product createEmptyProduct() {
		Product product = new Product();
		product.setName("empty");
		productService.save(product);
		return product;
	}
	
	public void deleteCurrentProduct() {
		if (currentProduct != null) {
			productService.delete(currentProduct);
			currentProduct = null;
		}
	}
	
	public void updateCurrentProduct(Product newProduct) {
		currentProduct.setName(newProduct.getName());
		currentProduct.setNumber(newProduct.getNumber());
		currentProduct.setDate(newProduct.getDate());
		productService.update(currentProduct);
	}
	
	public Product getProduct(int id) {
		return productService.getById(id);
	}

}
