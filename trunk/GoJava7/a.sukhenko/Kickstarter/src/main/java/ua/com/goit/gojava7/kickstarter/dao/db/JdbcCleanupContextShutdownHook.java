package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class JdbcCleanupContextShutdownHook implements ServletContextListener{

    private static final Logger logger = LoggerFactory.getLogger(JdbcCleanupContextShutdownHook.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        shutdownDaemonThread();
        unregisterDrivers();
    }

    private void unregisterDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                logger.debug("Unregistering JDBC driver: {}", driver);
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.warn("Cannot unregister JDBC driver: {}", driver, e);
            }
        }
    }

    private void shutdownDaemonThread() {
        try {
            logger.debug("Shutdown MySQL's AbandonedConnectionCleanupThread");
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
            logger.warn("Cannot shutdown MySQL's AbandonedConnectionCleanupThread", e);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }
}
