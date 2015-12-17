package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DatabaseDao<T>{
    protected List<T>    data;
    @Autowired
    protected DataSource dataSource;
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public abstract Connection getConnection() throws SQLException;

    protected abstract T readElement(ResultSet resultSet) throws SQLException;

    public abstract T getByNumber(int number);


    public abstract void setAll(List<T> data);

    public String prepareStringForDb(String original) {
        return original.replace("'", "\\'");
    }



    public abstract List<T> getAll();


    public abstract T get(int index);


    public abstract void add(T element);

    public abstract int size();

}
