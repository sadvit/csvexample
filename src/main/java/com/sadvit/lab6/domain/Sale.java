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
@Table(name = "sale")
public class Sale implements Tabular {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "saleId")
	private int saleId;
	
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "productId")
	private int productId;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "seat")
	private int seat;
	
	@Column(name = "date")
	private LocalDate date;
	
	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public Sale() {

	}

	public Sale(int customerId, int productId, LocalDate date, int count, int seat) {
		this.customerId = customerId;
		this.productId = productId;
		this.date = date;
		this.count = count;
		this.seat = seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + saleId;
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
		Sale other = (Sale) obj;
		if (saleId != other.saleId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", customerId=" + customerId
				+ ", productId=" + productId + ", date=" + date + ", count="
				+ count + ", seat=" + seat + "]";
	}

	@Override
	public StringProperty getColumnContent() {
		return new SimpleStringProperty(String.valueOf(saleId));
	}

	@Override
	public Integer getId() {
		return saleId;
	}	

}
