package com.sadvit.lab6.ui.mvp.contenteditor;

import org.springframework.beans.factory.annotation.Autowired;

import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter.TypeViewer;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractEditor;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractModel;

public class ContentEditorModel extends AbstractModel {
	
	@Autowired
	private AbstractEditor customerPresenter;

	@Autowired
	private AbstractEditor productPresenter;

	@Autowired
	private AbstractEditor salePresenter;
	
	private AbstractEditor currentEditor;

	public AbstractEditor getCurrentEditor() {
		return currentEditor;
	}

	public void setTypeEditor(TypeViewer typeViewer) {
		switch (typeViewer) {
		case CUSTOMER:
			currentEditor = customerPresenter;
			break;
		case PRODUCT:
			currentEditor = productPresenter;
			break;
		case SALE:
			currentEditor = salePresenter;
			break;
		default:
			break;
		}
	}
	
}
