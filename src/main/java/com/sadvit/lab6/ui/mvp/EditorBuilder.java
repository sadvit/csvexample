package com.sadvit.lab6.ui.mvp;

import com.sadvit.lab6.ui.Loader;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractEditor;

public class EditorBuilder {
	
	public static <C extends AbstractEditor> C build(String path) {
		return Loader.getInstance().loadController(path);
	}

}
