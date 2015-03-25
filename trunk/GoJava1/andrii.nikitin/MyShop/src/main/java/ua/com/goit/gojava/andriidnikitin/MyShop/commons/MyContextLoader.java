package ua.com.goit.gojava.andriidnikitin.MyShop.commons;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyContextLoader implements ApplicationContextAware {

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context = arg0;		
	}
	public static <T> T getBean(Class<T> class1) {
		return context.getBean(class1);	
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String string) {
		return (T) context.getBean(string);	
	}

}

