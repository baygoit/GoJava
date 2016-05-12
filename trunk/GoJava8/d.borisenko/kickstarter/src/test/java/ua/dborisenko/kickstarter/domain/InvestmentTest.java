package ua.dborisenko.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class InvestmentTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void mappingTest() {
        Category category = new Category();
        Project project = new Project();
        project.setCategory(category);
        Investment investment = new Investment();
        investment.setCardHolderName("testcardholder_name");
        investment.setCardNumber("testcard_number");
        investment.setAmount(100);
        investment.setProject(project);
        em.persist(category);
        em.persist(project);
        em.persist(investment);
        Query query = em.createQuery("FROM Investment");
        Investment resultInvestment = (Investment) query.getSingleResult();
        assertThat(resultInvestment.getCardHolderName(), is("testcardholder_name"));
        assertThat(resultInvestment.getCardNumber(), is("testcard_number"));
        assertThat(resultInvestment.getAmount(), is(100));
    }
}
