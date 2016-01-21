package integration.MySqlSuiteTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/MySql/applicationContext*.xml")
@Transactional
public class MySqlInsertIT {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaymentDao paymentDao;

    @Test
    public void testAddQuestion() {
        Category category = new Category();
        category.setName("New category for test");

        Project project = new Project();
        project.setName("New project for test");
        project.setCategory(category);

        Question question = new Question();
        question.setQuestion("New Question for test");
        question.setProject(project);

        questionDao.add(question);
        Long categoryId = category.getCategoryId();
        Long projectId = project.getProjectId();

        assertThat(categoryDao.get(categoryId).getName(), is("New category for test"));
        assertThat(projectDao.get(projectId).getName(), is("New project for test"));
    }

    @Test
    public void testAddPayment() {
        Category category = new Category();
        category.setName("New category for test adding payment");

        Project project = new Project();
        project.setName("New project for test adding payment");
        project.setCategory(category);

        Payment payment = new Payment();
        payment.setAmount(100L);
        payment.setCard("1234123412341234");
        payment.setUser("Vasya");
        payment.setProject(project);

        paymentDao.add(payment);
        Long categoryId = category.getCategoryId();
        Long projectId = project.getProjectId();

        assertThat(categoryDao.get(categoryId).getName(), is("New category for test adding payment"));
        assertThat(projectDao.get(projectId).getName(), is("New project for test adding payment"));
        assertThat(paymentDao.calculatePledgedForProject(projectId), is(100L));
    }
}
