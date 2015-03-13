package com.sadvit.exam.ui.mvp;

import com.sadvit.exam.ui.Loader;
import com.sadvit.exam.ui.mvp.skeleton.AbstractEditor;

public class EditorBuilder {
	
	public static <C extends AbstractEditor> C build(String path) {
		return Loader.getInstance().loadController(path);
	}

}
