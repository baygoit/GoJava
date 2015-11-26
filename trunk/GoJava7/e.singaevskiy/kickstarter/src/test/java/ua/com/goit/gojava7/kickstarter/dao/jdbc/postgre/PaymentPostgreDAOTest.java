package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.JdbcDispatcher;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class PaymentPostgreDAOTest {

    List<Payment> list;
    PaymentPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        Properties properties = Utils.readProperties("./src/test/resources/storages/db/config.properties");
        JdbcDispatcher dispatcher = new JdbcDispatcher(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"), 
                properties.getProperty("password"));
  
        
        list = new ArrayList<>();
        list.add(new Payment(1, "u1", 21312312, 10, null));
        list.add(new Payment(2, "u2", 21312312, 20, null));       
        
        dao = new PaymentPostgreDAO(dispatcher);         
    }
    
    @After
    public void tearDown() throws Exception {
        dao.clear();
    }

    @Test
    public void testAddGetAll() {
        dao.addAll(list);
        assertThat(dao.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
        assertFalse(true);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testException() throws Exception {
        JdbcDispatcher dispatcher = Mockito.mock(JdbcDispatcher.class);
        Mockito.when(dispatcher.getConnection()).thenThrow(SQLException.class);
        dao = new PaymentPostgreDAO(dispatcher); 
        dao.clear();
        dao.addAll(list);
        dao.getAll();
        dao.getByProject(1);
    }
    
    @Test
    public void testException1() throws Exception {
        Properties properties = Utils.readProperties("./kicks-files/config.properties");
        JdbcDispatcher dispatcher = new JdbcDispatcher(
                properties.getProperty("driver"),
                properties.getProperty("url"),
                properties.getProperty("user"), 
                properties.getProperty("password"));
        
        Connection connection = dispatcher.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO payment("
                + "            cardid, date, username, sum, project_id, reward_id)"
                + "    VALUES (?,      null, 'qwe' ,   123, 1,          ?)");
        prepareStatement.setLong(1, 36798653222L);
        prepareStatement.setNull(2, java.sql.Types.INTEGER);
        prepareStatement.executeUpdate();
        connection.commit();
        assertTrue(true);
    }
}
