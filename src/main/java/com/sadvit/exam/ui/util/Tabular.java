package com.sadvit.exam.ui.util;

import javafx.beans.property.StringProperty;

import com.sadvit.exam.domain.Customer;
import com.sadvit.exam.domain.Product;
import com.sadvit.exam.domain.Sale;
import com.sadvit.exam.service.Storeable;

public interface Tabular extends Storeable {
	
	public default String getColumnName() {
		if (this instanceof Customer) {
			return "Customers";
		}
		if (this instanceof Product) {
			return "Products";
		}
		if (this instanceof Sale) {
			return "Sales";
		}
		return "Types";
	}
	
	public StringProperty getColumnContent();

}
