package ua.com.goit.gojava7.kickstarter.controller.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;

@WebListener
public class ContextInitializer implements ServletContextListener {

	public static final String STORAGE_FACTORY = "storageFactory";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();

		StorageFactory factory = new StorageFactory(DataType.POSTGRE,
				getClass().getClassLoader().getResourceAsStream("config.properties"));

		ctx.setAttribute(STORAGE_FACTORY, factory);
		System.out.println("StorageFactory initialized successfully.");

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
