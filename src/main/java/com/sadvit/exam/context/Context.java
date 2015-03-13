package com.sadvit.exam.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Context {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(PresentersContext.class);
	
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

}
