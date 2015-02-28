package com.sadvit.lab6.ui.mvp.contentviewer;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter.TypeViewer;
import com.sadvit.lab6.ui.mvp.contenteditor.ContentEditorPresenter;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractPresenter;
import com.sadvit.lab6.ui.util.Tabular;

/**
 * Просмотрщик объектов. Представляет собой таблицу - в левой колонке приложения
 */
public class ContentViewerPresenter extends AbstractPresenter<AnchorPane, ContentViewerModel> {
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private TableView<Tabular> tableViewer;
	
	@Autowired
	private ContentEditorPresenter contentEditorPresenter; 

	@Override
	public AnchorPane getView() {
		return anchorPane;
	}
	
	private TypeViewer currentType;
	
	/**
	 * Меняет режим viewer-a на необходимый.
	 * @param typeViewer
	 */
	public void changeMode(TypeViewer typeViewer) {
		currentType = typeViewer;
		refresh();
	}
	
	private void clear() {
		tableViewer.getColumns().clear();
		tableViewer.getItems().clear();
	}
	
	private void refresh() {
		clear();
		TableColumn<Tabular, String> column = new TableColumn<>(currentType.toString());
		column.setCellValueFactory(data -> data.getValue().getColumnContent());		
		tableViewer.getColumns().add(column);
		List<Tabular> tabulars = getModel().getTabulars(currentType);
		if (tabulars != null) tableViewer.getItems().addAll(tabulars);
	}
	
	public void init() {
		contentEditorPresenter.setContentViewerPresenter(this);
		tableViewer
		.getSelectionModel()
		.selectedItemProperty()
		.addListener((observable, oldValue, value) -> {
			if (value != null)
				contentEditorPresenter.showType(value.getId());
		});
	}
	
	public void refreshViewer() {
		clear();
		refresh();
	}

}
