package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.Utils;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang3.time.DateUtils.addDays;
import static org.apache.commons.lang3.time.DateUtils.addHours;
import static org.apache.commons.lang3.time.DateUtils.addMinutes;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class CategoryViewTest {

    @Mock
    private CategoryModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderCategoryThenPrintNameAndProjectsList() throws Exception {
        when(model.getName()).thenReturn("Test Category");

        final int goal = 10000;
        final int balance = 1000;
        final int timeLag = 5;
        List<Project> projects = new ArrayList<>();
        Project project;

        project = new Project("1st project", goal, addMinutes(new Date(), timeLag));
        projects.add(project);

        project = new Project("2nd project", goal, addDays(new Date(), timeLag));
        project.setShortDescription("desc");
        projects.add(project);

        project = new Project("3rd project", goal, addHours(new Date(), timeLag));
        project.setShortDescription("desc");
        project.setBalance(balance);
        projects.add(project);

        when(model.getProjects()).thenReturn(projects);

        final List<String> view = new ArrayList<>();

        doAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                String str = (String) arguments[0];
                view.add(str);
                return null;
            }
        }).when(output).writeLine(anyString());
        CategoryView categoryView = new CategoryView();
        categoryView.setOutput(output);

        categoryView.render(model);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Test Category");

        expectedResult.add("[1]. 1st project");
        expectedResult.add(format("     Goal: %s", getMoney(projects.get(0).getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(projects.get(0).getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(projects.get(0).getDeadlineDate(), new Date())));

        expectedResult.add("[2]. 2nd project");
        expectedResult.add(format("     Short Description: %s", "desc"));
        expectedResult.add(format("     Goal: %s", getMoney(projects.get(1).getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(projects.get(1).getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(projects.get(1).getDeadlineDate(), new Date())));

        expectedResult.add("[3]. 3rd project");
        expectedResult.add(format("     Short Description: %s", "desc"));
        expectedResult.add(format("     Goal: %s", getMoney(projects.get(2).getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(projects.get(2).getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(projects.get(2).getDeadlineDate(), new Date())));

        expectedResult.add(BaseView.CHOICE_MESSAGE);
        Assert.assertArrayEquals("Not expected Category rendering", expectedResult.toArray(), view.toArray());
    }
}