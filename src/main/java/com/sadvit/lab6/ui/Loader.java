package com.sadvit.lab6.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

/**
 * Своим расположением маякует папку с FXML ресурсами
 * @author Vitalik
 *
 */
public class Loader {
	
	private static Loader instance;
	
	private Loader() {
		
	}
	
	public static Loader getInstance() {
		if (instance == null) instance = new Loader();
		return instance;
	}
	
	//--------------------------------------------------

	private static final String FOLDER = "views";
	
	private FXMLLoader loader;

	public <T> T loadController(String name) {
		try {
			loader = new FXMLLoader();
			loader.setLocation(getURL(name));
			loader.load();
			return loader.getController();
        } catch (Exception e) {
        	e.printStackTrace();
        	System.err.print("ОШИБКА ЗАГРУЗКИ ФАЙЛА FXML ");
        	return null;
        }
	}

	private static URL getURL(String viewName) {
		File file = new File(FOLDER, viewName);
		try {
			return file.toURI().toURL();
		} catch (MalformedURLException e) {
			return null;
		}
	}
	
}
