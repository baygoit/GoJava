package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class InvestmentTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void mappingTest() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        Investment investment = new Investment();
        investment.setCardHolderName("testcardholder_name");
        investment.setCardNumber("testcard_number");
        investment.setAmount(100);
        investment.setProject(project);
        session.save(category);
        session.save(project);
        session.save(investment);
        tx.commit();
        session.flush();
        session.close();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("FROM Investment");
        List<Investment> resultList = query.list();
        Investment resultInvestment = resultList.get(0);
        tx.commit();
        session.flush();
        session.close();
        assertThat(resultInvestment.getCardHolderName(), is("testcardholder_name"));
        assertThat(resultInvestment.getCardNumber(), is("testcard_number"));
        assertThat(resultInvestment.getAmount(), is(100));
    }
}
