package ua.com.goit.gojava1.lslayer.hackit2.common;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurationProvider {

    private static final Logger logger = LogManager.getLogger(ConfigurationProvider.class);

    @Bean
    public DataSource getDataSource() {
        logger.debug("DataSource Configuration started");
        InitialContext cxt;
        DataSource ds = null;
        try {
            cxt = new InitialContext();
            ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgresDS");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
