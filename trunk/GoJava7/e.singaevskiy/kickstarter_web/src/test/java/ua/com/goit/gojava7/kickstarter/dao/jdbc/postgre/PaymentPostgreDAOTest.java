package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentPostgreDAOTest {

    List<Payment> list;
    PaymentPostgreDAO dao;

    @Before
    public void setUp() throws Exception {
        dao = new PaymentPostgreDAO();
		dao.setJdbcTemplate(TestDaoFactory.setupJdbcTemplate()); 
        
        list = new ArrayList<>();
        list.add(new Payment(0, "u1", 21312312, 10, null));
        list.add(new Payment(0, "u2", 21312312, 20, null));       
       
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
        int index = 1;
        Payment payment = list.get(index);
        list.forEach(dao::add);
        assertThat(dao.get(index), is(payment));
    }

}
