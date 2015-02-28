package com.sadvit.lab6.ui;

import com.sadvit.lab6.context.Context;
import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationLoader extends Application {
	
	private BasePresenter basePresenter = Context.getBean(BasePresenter.class);

	@Override
	public void start(Stage primaryStage) {
		basePresenter.init();
		Pane rootLayout = basePresenter.getView();
		Scene scene = new Scene(rootLayout);		
		primaryStage.setTitle("Marketing of products");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
