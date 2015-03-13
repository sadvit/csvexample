package com.sadvit.exam.ui.mvp;

import com.sadvit.exam.ui.Loader;
import com.sadvit.exam.ui.mvp.skeleton.AbstractPresenter;

@SuppressWarnings("rawtypes")
public class PresenterBuilder {

	public static <P extends AbstractPresenter> P build(String path) {
		return Loader.getInstance().loadController(path);
	}

}
