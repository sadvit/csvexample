package com.sadvit.lab6.ui.mvp.skeleton;

import javafx.scene.Node;

import com.sadvit.lab6.ui.util.Tabular;


public interface EditorPresenter<M extends AbstractModel, V extends Node, E extends Tabular> {
	
	public M getModel();
	
	public void setModel(M model);
	
	public void clear();
	
	public void setContent(E entity);
	
	public E getContent();

}
