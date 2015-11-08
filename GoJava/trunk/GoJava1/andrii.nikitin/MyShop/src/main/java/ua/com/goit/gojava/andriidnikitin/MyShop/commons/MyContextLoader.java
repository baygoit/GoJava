package ua.com.goit.gojava.andriidnikitin.MyShop.commons;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MyContextLoader implements ApplicationContextAware {

	private static ApplicationContext context;
	private static Logger log = Logger.getLogger("MyShop.commons");
	
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
	
	public static void logBeans(){
		String[] names = context.getBeanDefinitionNames();
		log.info("beans<****************");
		for (String name: names){
			log.info(name);
		}
		log.info("****************>");
	}		
}
