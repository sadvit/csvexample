package com.sadvit.lab6.ui.util;

import javafx.beans.property.StringProperty;

import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.domain.Sale;
import com.sadvit.lab6.service.Storeable;

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
