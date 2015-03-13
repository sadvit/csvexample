package com.sadvit.exam.ui.mvp.baseeditor;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.sadvit.exam.ui.mvp.contenteditor.ContentEditorPresenter;
import com.sadvit.exam.ui.mvp.contentviewer.ContentViewerPresenter;
import com.sadvit.exam.ui.mvp.skeleton.AbstractPresenter;
import com.sadvit.exam.ui.viewer.SalePresenter;

public class BasePresenter extends AbstractPresenter<BorderPane, BaseModel> {

	@FXML
	private BorderPane borderPane;

	@FXML
	private SplitPane splitPane;

	@FXML
	private ToggleGroup radioGroup;

	@Autowired
	private ContentEditorPresenter contentEditorPresenter;

	@Autowired
	private ContentViewerPresenter contentViewerPresenter;
	
	@Autowired
	private SalePresenter salePresenter; 

	public void init() {
		addNodes(contentViewerPresenter.getView(), contentEditorPresenter.getView());
		contentViewerPresenter.init();
		salePresenter.init();
	}

	private void addNodes(Node leftNode, Node rightNode) {
		StackPane leftPane = new StackPane();
		leftPane.getChildren().add(leftNode);
		StackPane rightPane = new StackPane();
		rightPane.getChildren().add(rightNode);
		splitPane.getItems().addAll(leftPane, rightPane);
		splitPane.setDividerPositions(0.25);
	}

	@Override
	public BorderPane getView() {
		return borderPane;
	}

	@FXML
	public void saleButtonAction() {
		changeViewMode(TypeViewer.SALE);
	}

	@FXML
	public void customerButtonAction() {
		changeViewMode(TypeViewer.CUSTOMER);
	}

	@FXML
	public void productButtonAction() {
		changeViewMode(TypeViewer.PRODUCT);
	}

	private void changeViewMode(TypeViewer typeViewer) {
		contentEditorPresenter.changeMode(typeViewer);
		contentViewerPresenter.changeMode(typeViewer);
	}

	public enum TypeViewer {
		PRODUCT, CUSTOMER, SALE
	}

}
