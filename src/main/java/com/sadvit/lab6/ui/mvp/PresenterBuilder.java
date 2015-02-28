package com.sadvit.lab6.ui.mvp;

import com.sadvit.lab6.ui.Loader;
import com.sadvit.lab6.ui.mvp.skeleton.AbstractPresenter;

@SuppressWarnings("rawtypes")
public class PresenterBuilder {

	public static <P extends AbstractPresenter> P build(String path) {
		return Loader.getInstance().loadController(path);
	}

}
