package ua.com.goit.gojava7.kickstarter.dao.db;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public CategoryDatabaseDao getCategoryDatabaseDao(){
        return new CategoryDatabaseDao();
    }
    
    @Bean 
    public DataSource getDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/kickstarter");
        dataSource.setUsername("kickadmin");
        dataSource.setPassword("kickpass");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDefaultAutoCommit(true);
        return dataSource;
    }
}
