package com.sadvit.exam.ui;

import com.sadvit.exam.context.Context;
import com.sadvit.exam.ui.mvp.baseeditor.BasePresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.log4j.PropertyConfigurator;

public class ApplicationLoader extends Application {

    private static final String LOG_PROPERTY_PATH = "log4j.properties";
	
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
        PropertyConfigurator.configure(LOG_PROPERTY_PATH);
		launch(args);
	}
}
