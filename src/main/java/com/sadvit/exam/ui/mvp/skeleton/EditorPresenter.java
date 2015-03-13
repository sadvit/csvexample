package com.sadvit.exam.ui.mvp.skeleton;

import com.sadvit.exam.ui.util.Tabular;
import javafx.scene.Node;

public interface EditorPresenter<M extends AbstractModel, V extends Node, E extends Tabular> {
	
	public M getModel();
	
	public void setModel(M model);
	
	public void clear();
	
	public void setContent(E entity);
	
	public E getContent();

}
