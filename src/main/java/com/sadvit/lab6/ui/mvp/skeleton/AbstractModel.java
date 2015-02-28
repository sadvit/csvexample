package com.sadvit.lab6.ui.mvp.skeleton;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sadvit.lab6.service.CustomerService;
import com.sadvit.lab6.service.ProductService;
import com.sadvit.lab6.service.SaleService;
import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter.TypeViewer;
import com.sadvit.lab6.ui.util.Tabular;

/**
 * Модель занимается загрузкой данных с прослойки сервисов.
 */
public class AbstractModel {

	@Autowired
	protected CustomerService customerService;

	@Autowired
	protected SaleService saleService;

	@Autowired
	protected ProductService productService;

	public List<Tabular> getTabulars(TypeViewer type) {
		switch (type) {
		case CUSTOMER:
			return customerService.getCustomerTabulars();
		case PRODUCT:
			return productService.getProductTabulars();
		case SALE:
			return saleService.getSaleTabulars();
		default:
			return null;
		}
	}

}
