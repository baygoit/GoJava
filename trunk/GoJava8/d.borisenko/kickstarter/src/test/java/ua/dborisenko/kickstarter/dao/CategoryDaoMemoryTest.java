package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public class CategoryDaoMemoryTest {

    private static CategoryDaoMemory categoryDao = new CategoryDaoMemory();

    @BeforeClass
    public static void prepareData() {
        categoryDao.fillData();
    }
    
    @Test
    public void getByNameTest() {
        assertThat(categoryDao.getByName("Sport"), notNullValue());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void getByNameTestWrong() {
        categoryDao.getByName("Blablabla");
    }
    
    @Test
    public void getCategoryNamesTest() { 
        List<String> categoryNames = categoryDao.getCategoryNames();
        assertTrue(categoryNames.size() > 0);
    }

    @Test
    public void addInvestmentsTest() {
        Investment investment = new Investment();
        investment.setCardHolderName("testcardholdername");
        investment.setCardNumber("111222333");
        investment.setAmount(100);
        Project project = new Project();
        categoryDao.addInvestment(project, investment);
        boolean resultFlag = false;
        for (Investment currentInvestment : project.getInvestments()) {
            if (currentInvestment == investment) {
                resultFlag = true;
            }
        }
        assertTrue(resultFlag);
    }
    
    @Test
    public void addQuestionTest() {
        Question question = new Question();
        question.setRequest("testrequest");
        question.setReply("testreply");
        Project project = new Project();
        categoryDao.addQuestion(project, question);
        boolean resultFlag = false;
        for (Question currentQuestion : project.getQuestions()) {
            if (currentQuestion == question) {
                resultFlag = true;
            }
        }
        assertTrue(resultFlag);
    }
}
