package com.sadvit.lab6.domain;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sadvit.lab6.ui.util.Tabular;


@Entity
@Table(name = "product")
public class Product implements Tabular {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "productId")
	private Integer productId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "date")
	private LocalDate date;
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Object[] getParams() {
		return new Object[]{productId, name};
	}
	
	public Product(String name, int number, LocalDate date) {
		this.name = name;
		this.number = number;
		this.date = date;
	}
	
	public Product() {

	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", number=" + number + ", date=" /*date*/;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public StringProperty getColumnContent() {
		return new SimpleStringProperty(name);
	}

	@Override
	public Integer getId() {
		return productId;
	}

}
