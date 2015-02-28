package com.sadvit.lab6.ui.viewer;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.domain.Sale;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractEditor;
import com.sadvit.lab6.ui.mvp.skeleton.EditorPresenter;
import com.sadvit.lab6.ui.util.Tabular;

public class SalePresenter extends AbstractEditor implements EditorPresenter<SaleModel, Node, Sale> {

	private SaleModel model;

	@FXML
	ComboBox<Tabular> customerBox;

	@FXML
	ComboBox<Tabular> productBox;

	@FXML
	TextField count;

	@FXML
	TextField seat;

	@FXML
	DatePicker date;

	@FXML
	public void customerBoxHandler() {
		getModel().setCurrentCustomer((Customer) customerBox.getSelectionModel().getSelectedItem());
	}

	@FXML
	public void productBoxHandler() {
		getModel().setCurrentProduct((Product) productBox.getSelectionModel().getSelectedItem());
	}

	@Override
	public void clear() {
		customerBox.getItems().clear();
		productBox.getItems().clear();
		count.setText("");
		seat.setText("");
		date.setValue(null);
	}

	@Override
	public void setContent(Sale sale) {
		if (sale == null) {
			clear();
			return;
		}
		count.setText(String.valueOf(sale.getCount()));
		seat.setText(String.valueOf(sale.getSeat()));
		date.setValue(sale.getDate());
		refresh();
		setSelectedCustomer(sale.getCustomerId());
		setSelectedProduct(sale.getProductId());
		getModel().setCurrentSale(sale);
	}

	@Override
	public void updateHandler() {
		Sale actual = getContent();
		if (actual != null)
			getModel().updateCurrentSale(actual);
	}

	@Override
	public void createHandler() {
		getModel().createEmptySale();
	}

	@Override
	public void deleteHandler() {
		clear();
		getModel().deleteCurrentSale();
	}

	@Override
	public SaleModel getModel() {
		return model;
	}

	@Override
	public void setModel(SaleModel model) {
		this.model = model;
	}

	private void fillCustomerList(List<Tabular> tabulars) {
		customerBox.getItems().clear();
		customerBox.getItems().addAll(tabulars);
	}

	private void fillProductList(List<Tabular> tabulars) {
		productBox.getItems().clear();
		productBox.getItems().addAll(tabulars);
	}

	private void setSelectedCustomer(int id) {
		if (id == 0) {
			customerBox.getSelectionModel().clearSelection();
			customerBox.setValue(null);
		} else {
			try {
				Tabular tabular = customerBox.getItems().stream().filter(value -> value.getId() == id).findFirst().get();
				int index = customerBox.getItems().indexOf(tabular);
				customerBox.getSelectionModel().select(index);
				getModel().setCurrentCustomer((Customer) tabular);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void setSelectedProduct(int id) {
		if (id == 0) {
			productBox.getSelectionModel().clearSelection();
			productBox.setValue(null);
		} else {
			try {
				Tabular tabular = productBox.getItems().stream().filter(value -> value.getId() == id).findFirst().get();
				int index = productBox.getItems().indexOf(tabular);
				productBox.getSelectionModel().select(index);
				getModel().setCurrentProduct((Product) tabular);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Sale getContent() {
		try {
			int customerId = customerBox.getSelectionModel().getSelectedItem().getId();
			int productId = productBox.getSelectionModel().getSelectedItem().getId();
			return new Sale(customerId, productId, date.getValue(), Integer.parseInt(count.getText()),Integer.parseInt(seat.getText()));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void withdraw(int id) {
		refresh();
		setContent(getModel().getSale(id));
	}

	@Override
	public void refresh() {
		fillCustomerList(getModel().getCustomers());
		fillProductList(getModel().getProducts());
	}

	public void init() {
		customerBox.setCellFactory(combo -> new ListCell<Tabular>() {
			@Override
			protected void updateItem(Tabular item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getColumnContent().getValue());
				}
			}
		});
		customerBox.setConverter(new StringConverter<Tabular>() {
			@Override
			public String toString(Tabular tabular) {
				return tabular.getColumnContent().getValue();
			}

			@Override
			public Tabular fromString(String string) {
				return null;
			}
		});
		productBox.setCellFactory(combo -> new ListCell<Tabular>() {
			@Override
			protected void updateItem(Tabular item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getColumnContent().getValue());
				}
			}
		});
		productBox.setConverter(new StringConverter<Tabular>() {
			@Override
			public String toString(Tabular tabular) {
				return tabular.getColumnContent().getValue();
			}

			@Override
			public Tabular fromString(String string) {
				return null;
			}
		});
	}

}
