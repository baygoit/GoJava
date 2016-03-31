package ua.dborisenko.kickstarter.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

public class CategoryDaoFileTest {
    private static CategoryDaoFile categoryDao = new CategoryDaoFile();
    private String categoriesFileName = "./src/test/resources/categories.txt";
    private String projectsFileName = "./src/test/resources/projects.txt";
    private String questionsFileName = "./src/test/resources/questions.txt";
    private String investmentsFileName = "./src/test/resources/investments.txt";
    private String categoriesWrongFileName = "./src/test/resources/categories_wrongformat.txt";
    private String projectsWrongFileName = "./src/test/resources/projects_wrongformat.txt";
    private String questionsWrongFileName = "./src/test/resources/questions_wrongformat.txt";
    private String investmentsWrongFileName = "./src/test/resources/investments_wrongformat.txt";

    @Ignore
    @Test
    public void fillCategoriesTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.fillCategories();
        Category category = categoryDao.categories.get(0);
        assertThat(category.getId(), is(1));
        assertThat(category.getName(), is("testcategory"));
    }

    @Test(expected = IllegalStateException.class)
    public void fillCategoriesWrongFileTest() {
        categoryDao.setCategoriesFileName(categoriesWrongFileName);
        categoryDao.fillCategories();
    }

    @Ignore
    @Test(expected = IllegalStateException.class)
    public void fillProjectsWrongFileTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.fillCategories();
        categoryDao.setProjectsFileName(projectsWrongFileName);
        categoryDao.fillProjects();
    }

    @Test(expected = IllegalStateException.class)
    public void fillQuestionsWrongFileTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.setProjectsFileName(projectsFileName);
        categoryDao.setQuestionsFileName(questionsWrongFileName);
        categoryDao.fillCategories();
        categoryDao.fillProjects();
        Project project = categoryDao.getProjectById(1);
        categoryDao.getQuestions(project);
    }

    @Test(expected = IllegalStateException.class)
    public void fillInvestmentsWrongFileTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.fillCategories();
        categoryDao.setProjectsFileName(projectsFileName);
        categoryDao.fillProjects();
        categoryDao.setInvestmentsFileName(investmentsWrongFileName);
        categoryDao.fillInvestments();
    }

    @Ignore
    @Test
    public void fillProjectsTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.setProjectsFileName(projectsFileName);
        categoryDao.fillCategories();
        categoryDao.fillProjects();
        Project project = categoryDao.getProjectById(1);
        assertThat(project.getId(), is(1));
        assertThat(project.getName(), is("testname"));
        assertThat(project.getDescription(), is("testdescription"));
        assertThat(project.getHistory(), is("testhistory"));
        assertThat(project.getRequiredSum(), is(111));
        assertThat(project.getDaysLeft(), is(222));
        assertThat(project.getVideoUrl(), is("testvideourl"));
    }

    @Ignore
    @Test
    public void fillQuestionsTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.setProjectsFileName(projectsFileName);
        categoryDao.setQuestionsFileName(questionsFileName);
        categoryDao.fillCategories();
        categoryDao.fillProjects();
        Project project = categoryDao.getProjectById(1);
        categoryDao.getQuestions(project);
        Question question = project.getQuestions().get(0);
        assertThat(question.getId(), is(1));
        assertThat(question.getRequest(), is("testrequest"));
        assertThat(question.getReply(), is("testreply"));
    }

    @Ignore
    @Test
    public void fillInvestmentsTest() {
        categoryDao.setCategoriesFileName(categoriesFileName);
        categoryDao.setProjectsFileName(projectsFileName);
        categoryDao.setInvestmentsFileName(investmentsFileName);
        categoryDao.fillCategories();
        categoryDao.fillProjects();
        categoryDao.fillInvestments();
        Project project = categoryDao.getProjectById(1);
        Investment investment = project.getInvestments().get(0);
        assertThat(investment.getId(), is(1));
        assertThat(investment.getCardHolderName(), is("testcardholdername"));
        assertThat(investment.getCardNumber(), is("testcardnumber"));
        assertThat(investment.getAmount(), is(111));
    }
}
