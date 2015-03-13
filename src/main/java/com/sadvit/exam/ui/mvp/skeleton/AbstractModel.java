package com.sadvit.exam.ui.mvp.skeleton;

import com.sadvit.exam.service.CustomerService;
import com.sadvit.exam.service.ProductService;
import com.sadvit.exam.service.SaleService;
import com.sadvit.exam.ui.mvp.baseeditor.BasePresenter.TypeViewer;
import com.sadvit.exam.ui.util.Tabular;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
