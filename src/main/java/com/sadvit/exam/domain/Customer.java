package com.sadvit.exam.domain;

import com.sadvit.exam.ui.util.Tabular;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer implements Tabular {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "seat")
	private int seat;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getSeat() {
		return seat;
	}
	
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public Customer(String name, String address, int seat) {
		this.name = name;
		this.address = address;
		this.seat = seat;
	}
	
	public Customer() {

	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name
				+ ", address=" + address + ", seat=" + seat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	@Override
	public StringProperty getColumnContent() {
		return new SimpleStringProperty(name);
	}

	@Override
	public Integer getId() {
		return customerId;
	}

}
