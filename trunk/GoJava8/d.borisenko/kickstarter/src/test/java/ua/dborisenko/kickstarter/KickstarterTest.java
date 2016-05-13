package ua.dborisenko.kickstarter;

import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {

    @Mock
    private HttpServletResponse response;
    @Mock
    private CategoryController categoryController;
    @Mock
    private ProjectController projectController;
    @Mock
    private InvestmentController investmentController;
    @InjectMocks
    private Kickstarter kickstarter;
    private MockHttpServletRequest request = new MockHttpServletRequest();;

    @Test
    public void doGetShowCategoriesTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.setParameter(Kickstarter.REQUESTED_PAGE_PARAM_NAME, Kickstarter.REQUESTED_PAGE.categories.toString());
        kickstarter.doGet(request, response);
        verify(categoryController).showCategories(request, response);
    }

    @Test
    public void doGetShowCategoryTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.setParameter(Kickstarter.REQUESTED_PAGE_PARAM_NAME, Kickstarter.REQUESTED_PAGE.category.toString());
        kickstarter.doGet(request, response);
        verify(categoryController).showCategory(request, response);
    }

    @Test
    public void doGetShowProjectTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.setParameter(Kickstarter.REQUESTED_PAGE_PARAM_NAME, Kickstarter.REQUESTED_PAGE.project.toString());
        kickstarter.doGet(request, response);
        verify(projectController).showProject(request, response);
    }

    @Test
    public void doGetShowInvestmentTest() throws ServletException, IOException {
        request.setQueryString("foo");
        request.setParameter(Kickstarter.REQUESTED_PAGE_PARAM_NAME, Kickstarter.REQUESTED_PAGE.investment.toString());
        kickstarter.doGet(request, response);
        verify(investmentController).showInvestment(request, response);
    }

    @Test
    public void doGetNotFoundTest() throws ServletException, IOException {
        request.setQueryString("foo");
        kickstarter.doGet(request, response);
        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.PAGE_NOT_FOUND);
    }

    @Test
    public void doPostAddQuestionTest() throws ServletException, IOException {
        request.setParameter(Kickstarter.REQUESTED_ACTION_PARAM_NAME,
                Kickstarter.REQUESTED_ACTION.add_question.toString());
        kickstarter.doPost(request, response);
        verify(projectController).addQuestion(request, response);
    }

    @Test
    public void doPostAddInvestmentTest() throws ServletException, IOException {
        request.setParameter(Kickstarter.REQUESTED_ACTION_PARAM_NAME,
                Kickstarter.REQUESTED_ACTION.add_investment.toString());
        kickstarter.doPost(request, response);
        verify(investmentController).addInvestment(request, response);
    }

    @Test
    public void doPostNotFoundTest() throws ServletException, IOException {
        kickstarter.doPost(request, response);
        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND, ErrorText.ACTION_NOT_FOUND);
    }
}
