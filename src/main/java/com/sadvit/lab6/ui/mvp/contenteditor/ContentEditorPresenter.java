package com.sadvit.lab6.ui.mvp.contenteditor;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter.TypeViewer;
import com.sadvit.lab6.ui.mvp.contentviewer.ContentViewerPresenter;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractPresenter;

/**
 * Представляет собой редактор объектов - правую колонку
 */
public class ContentEditorPresenter extends AbstractPresenter<BorderPane, ContentEditorModel> {

	@FXML
	private BorderPane borderPane;

	private ContentViewerPresenter contentViewerPresenter;

	public void setContentViewerPresenter(ContentViewerPresenter contentViewerPresenter) {
		this.contentViewerPresenter = contentViewerPresenter;
	}

	@Override
	public BorderPane getView() {
		return borderPane;
	}

	/**
	 * Меняет режим editor-a на необходимый.
	 * @param typeViewer
	 */
	public void changeMode(TypeViewer typeViewer) {
		getModel().setTypeEditor(typeViewer);
		refresh();
	}

	@FXML
	public void onNewClickHandler() {
		getModel().getCurrentEditor().createHandler();
		refreshViewer();
	}

	@FXML
	public void onSaveClickHandler() {
		getModel().getCurrentEditor().updateHandler();
		refreshViewer();
	}

	@FXML
	public void onDeleteClickHandler() {
		getModel().getCurrentEditor().deleteHandler();
		refreshViewer();
	}

	private void setCenterNode(Node node) {
		getView().setCenter(node);
	}

	private void refresh() {
		setCenterNode(getModel().getCurrentEditor().getView());
	}
	
	private void refreshViewer() {
		contentViewerPresenter.refreshViewer();
	}
	
	public void showType(int id) {
		getModel().getCurrentEditor().withdraw(id);
	}

}
