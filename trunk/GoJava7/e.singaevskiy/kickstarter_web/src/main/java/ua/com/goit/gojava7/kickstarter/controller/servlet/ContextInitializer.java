package ua.com.goit.gojava7.kickstarter.controller.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;

@WebListener
public class ContextInitializer implements ServletContextListener {

	public static final String STORAGE_FACTORY = "storageFactory";

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		if (sce.getServletContext().getAttribute(STORAGE_FACTORY) == null) {
			ServletContext ctx = sce.getServletContext();

			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			StorageFactory factory = context.getBean(StorageFactory.class);

			ctx.setAttribute(STORAGE_FACTORY, factory);
			System.out.println("StorageFactory initialized successfully.");
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		StorageFactory factory = (StorageFactory) sce.getServletContext().getAttribute(STORAGE_FACTORY);
		if (factory != null) {
			factory.close();
			System.out.println("StorageFactory closed.");
		}
	}

}
