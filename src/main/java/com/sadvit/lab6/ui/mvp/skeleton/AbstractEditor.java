package com.sadvit.lab6.ui.mvp.skeleton;

import javafx.fxml.FXML;
import javafx.scene.Node;

/**
 * Конкретный редактор для любого типа.
 */
public abstract class AbstractEditor {
	
	@FXML
	private Node editPane;
	
	public final Node getView() {
		return editPane;
	}
	
	public abstract void refresh();
	
	public abstract void updateHandler();
	
	public abstract void createHandler();
	
	public abstract void deleteHandler();
	
	public abstract void withdraw(int id);

}
