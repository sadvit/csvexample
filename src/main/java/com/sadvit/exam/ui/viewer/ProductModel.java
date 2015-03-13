package com.sadvit.exam.ui.viewer;

import com.sadvit.exam.domain.Product;
import com.sadvit.exam.ui.mvp.skeleton.AbstractModel;
import org.springframework.stereotype.Component;

@Component
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
