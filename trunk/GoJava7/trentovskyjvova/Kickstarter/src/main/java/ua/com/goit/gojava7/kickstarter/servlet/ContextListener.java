package ua.com.goit.gojava7.kickstarter.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;

@WebListener
public class ContextListener implements ServletContextListener {

	public static final String STORAGE_FACTORY = "storageFactory";
	public static final String DATA_SOURCE_TYPE = "DataSourceType";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		if (sce.getServletContext().getAttribute(STORAGE_FACTORY) == null) {
			ServletContext ctx = sce.getServletContext();

			String parameterDataSourceType = ctx.getInitParameter("DataSourceType");
			DataSourceTypes dataSourceType;
			
			if (parameterDataSourceType.equals("mysql")) {
				dataSourceType = DataSourceTypes.MYSQL;
			} else if (parameterDataSourceType.equals("postgres")) {
				dataSourceType = DataSourceTypes.POSTGRES;
			} else if (parameterDataSourceType.equals("file")) {
				dataSourceType = DataSourceTypes.FILE;
			} else {
				dataSourceType = DataSourceTypes.MEMORY;
			}
			
			DaoProvider factory = new DaoProvider(dataSourceType);

			ctx.setAttribute(STORAGE_FACTORY, factory);
			System.out.println("StorageFactory initialized successfully.");
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		DaoProvider factory = (DaoProvider) sce.getServletContext().getAttribute(STORAGE_FACTORY);
		if (factory != null) {
			factory.close();
			System.out.println("StorageFactory closed.");
		}

	}

}
