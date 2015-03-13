package com.sadvit.exam.context;

import com.sadvit.exam.ui.mvp.EditorBuilder;
import com.sadvit.exam.ui.mvp.PresenterBuilder;
import com.sadvit.exam.ui.mvp.baseeditor.BaseModel;
import com.sadvit.exam.ui.mvp.baseeditor.BasePresenter;
import com.sadvit.exam.ui.mvp.contenteditor.ContentEditorModel;
import com.sadvit.exam.ui.mvp.contenteditor.ContentEditorPresenter;
import com.sadvit.exam.ui.mvp.contentviewer.ContentViewerModel;
import com.sadvit.exam.ui.mvp.contentviewer.ContentViewerPresenter;
import com.sadvit.exam.ui.viewer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sadvit.exam")
public class PresentersContext {
	
	@Bean
	@Autowired
	public SalePresenter salePresenter(SaleModel saleModel) {
		SalePresenter salePresenter = EditorBuilder.build("SaleViewer.fxml");
		salePresenter.setModel(saleModel);
		return salePresenter;
	}
	
	@Bean
	@Autowired
	public ProductPresenter productPresenter(ProductModel productModel) {
		ProductPresenter productPresenter = EditorBuilder.build("ProductViewer.fxml");
		productPresenter.setModel(productModel);
		return productPresenter;
	}
	
	@Bean
	@Autowired
	public CustomerPresenter customerPresenter(CustomerModel customerModel) {
		CustomerPresenter customerPresenter = EditorBuilder.build("CustomerViewer.fxml");
		customerPresenter.setModel(customerModel);
		return customerPresenter;
	}
	
	@Bean
	@Autowired
	public ContentViewerPresenter contentViewerPresenter(ContentViewerModel contentViewerModel) {
		ContentViewerPresenter contentViewerPresenter = PresenterBuilder.build("ContentViewerView.fxml");
		contentViewerPresenter.setModel(contentViewerModel);
		return contentViewerPresenter;
	}
	
	@Bean
	@Autowired
	public ContentEditorPresenter contentEditorPresenter(ContentEditorModel contentEditorModel) {
		ContentEditorPresenter contentEditorPresenter = PresenterBuilder.build("ContentEditorView.fxml");
		contentEditorPresenter.setModel(contentEditorModel);
		return contentEditorPresenter;
	}
	
	@Bean
	@Autowired
	public BasePresenter basePresenter(BaseModel baseModel) {
		BasePresenter basePresenter = PresenterBuilder.build("BaseView.fxml");
		basePresenter.setModel(baseModel);
		return basePresenter;
	}
	
}
