package ua.com.goit.gojava7.kickstarter.dao.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-db.xml",
"classpath:applicationContext.xml"})
@Transactional
public class ITPaymentDaoTest {


    @Autowired
    private PaymentDatabaseDao paymentDao;
    @Autowired
    private ProjectDatabaseDao projectDao;
   @Test
   public void testGetAll(){
       assertThat(paymentDao.getAll().isEmpty(),is(false));
   }
   
   @Test
   public void testGetPaymentsByProjectId(){
       assertThat(paymentDao.getPaymentsByProjectId(1).size(),is(1));
   }
   
   @Test
   public void testAddPayment(){
       //int size = paymentDao.getAll().size();
       assertThat(paymentDao.createPayment("1234432112344321", "Name Else", Long.valueOf(12345), projectDao.getProjectByName("Movie 1")),is(true));
      // assertThat(paymentDao.getAll().size(),is(size+1));
   }
}
