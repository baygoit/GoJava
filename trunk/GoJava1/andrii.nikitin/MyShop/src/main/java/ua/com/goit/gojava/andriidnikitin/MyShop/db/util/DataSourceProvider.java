package ua.com.goit.gojava.andriidnikitin.MyShop.db.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("dataSource")
public class DataSourceProvider {
	
	private static final String CLASSNAME = DataSourceProvider.class.getCanonicalName();
	   
	private static Logger log = Logger.getLogger("MyShop.Dao.commons");
		
	private static DataSource dataSource;

	@Bean
	public static DataSource getDataSource() {
        log.debug("DataSource configuration started");
        InitialContext cxt;
        dataSource = null;
        try {
            cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/ShopDS");
        } catch (NamingException e) {
            log.error("lookuping datasource by " + CLASSNAME, e);
        }
        if (dataSource==null){
        	 log.warn("DataSource is null");
        }    
        else {
        	log.info("DataSource successfully created");
        }
        return dataSource;
    }
}
