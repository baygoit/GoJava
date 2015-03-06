package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(DataSourceProvider.class)
public class JdbcSQLRunner {

    @Autowired
    DataSource ds;
    
    public String executeSQL(String query) {
        System.out.println(ds);
        return null;
    }

}
