package com.hunter.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

public class ApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		User user = applicationContext.getBean(User.class);
		System.out.println(user);
		
	}
}
