package com.sadvit.exam.ui.mvp.skeleton;

import javafx.scene.layout.Pane;


public abstract class AbstractPresenter<V extends Pane, M extends AbstractModel> {
	
	protected M model;
	
	public abstract V getView();
	
	public final void setModel(M model) {
		this.model = model;
	}
	
	public final M getModel() {
		return model;
	}

}
