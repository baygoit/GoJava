package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@ContextConfiguration(locations = { "classpath:testApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class InvestmentDaoTest {

    @Autowired
    private InvestmentDao investmentDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void getAllForProjectTest() {
        Category category = new Category();
        categoryDao.add(category);
        Project project = new Project();
        project.setCategory(category);
        project.setName("testname");
        projectDao.add(project);
        Investment investment = new Investment();
        investment.setAmount(100);
        investment.setCardHolderName("testname");
        investment.setCardNumber("testnumber");
        investment.setProject(project);
        investmentDao.add(investment);
        investmentDao.getAllForProject(project);
        assertThat(project.getInvestments().isEmpty(), is(false));
        for (Investment currentInvestment : project.getInvestments()) {
            assertThat(currentInvestment.getCardHolderName(), is("testname"));
            assertThat(currentInvestment.getCardNumber(), is("testnumber"));
            assertThat(currentInvestment.getAmount(), is(100));
        }
    }
}
