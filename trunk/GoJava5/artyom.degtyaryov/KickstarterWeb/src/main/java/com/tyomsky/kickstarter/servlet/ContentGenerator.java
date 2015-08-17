package com.tyomsky.kickstarter.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ContentGenerator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        initializeDataSourceContent();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //do nothing
    }

    private void initializeDataSourceContent() {
        System.out.println("generating content in H2 data base...");
        Context jndiContext = null;
        DataSource dataSource;
        try {
            jndiContext = new InitialContext();
            dataSource = (javax.sql.DataSource) jndiContext.lookup("java:comp/env/jdbc/KickstarterDS");
        } catch (NamingException e) {
            throw new RuntimeException("Resource jdbc/KickstarterDS is not found!", e);
        }
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE CATEGORIES\n" +
                    "(\n" +
                    "    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                    "    NAME CLOB NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE QUOTES\n" +
                    "(\n" +
                    "    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                    "    PRESENTATION CLOB NOT NULL\n" +
                    ");\n" +
                    "CREATE TABLE PROJECTS\n" +
                    "(\n" +
                    "    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                    "    NAME CLOB NOT NULL,\n" +
                    "    DESCRIPTION CLOB NOT NULL,\n" +
                    "    CATEGORY_ID INTEGER NOT NULL,\n" +
                    "    COST INTEGER,\n" +
                    "    BALANCE INTEGER,\n" +
                    "    DEADLINE CLOB,\n" +
                    "    VIDEOLINK CLOB,\n" +
                    "    HISTORY CLOB,\n" +
                    "    QUESTIONSANDANSWERS CLOB\n" +
                    ");\n" +
                    "INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION) VALUES (1, '\"If you want to achieve greatness stop asking for permission.\" --Anonymous');\n" +
                    "INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION) VALUES (2, '\"Things work out best for those who make the best of how things work out.\" --John Wooden');\n" +
                    "INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION) VALUES (3, '\"If you are not willing to risk the usual you will have to settle for the ordinary.\" --Jim Rohn');\n" +
                    "INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (1, 'Games');\n" +
                    "INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (2, 'Music');\n" +
                    "INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (3, 'Films');" +
                    "INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEADLINE, VIDEOLINK, HISTORY, QUESTIONSANDANSWERS) VALUES (2, 'StarCraft 2', 'continue of epic game', 1, 5000000, 0, '01/01/2017', 'https://youtu.be/MVbeoSPqRs4', null, null);\n" +
                    "INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEADLINE, VIDEOLINK, HISTORY, QUESTIONSANDANSWERS) VALUES (3, 'Kosinka 2', '2-nd part of epic game', 1, 3000000, 0, '01/01/2016', 'https://youtu.be/CckOHAGPB0Q', 'We have collected 100000$ now. We need to collect more to start development.', 'Q: Will you develop version for Mac and Linux? A: No. Only Windows');\n" +
                    "INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEADLINE, VIDEOLINK, HISTORY, QUESTIONSANDANSWERS) VALUES (1, 'GTA 5', '5-th episode of epic game', 1, 100000, 0, '01/01/2016', 'https://youtu.be/SC66xH7s-0M', 'we just starter and its nothing to say now! To be continue.', 'Q: when will you release PC version? A: Next year.');\n");
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Can't establish connection with DB", e);
        }


    }
}
