package ua.com.goit.gojava.solo307.intersim.commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextProvider {
	private static final String FILE_NAME = "beans.xml";

	public static Object getBean(String beanId) {
		ApplicationContext context = new ClassPathXmlApplicationContext(FILE_NAME);
		return context.getBean(beanId);
	}
}
