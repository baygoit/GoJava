package ua.goit.kyrychok.kickstarter.mvc.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.TestDataProvider;
import ua.goit.kyrychok.kickstarter.Utils;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectViewTest {

    @Mock
    private ProjectModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderProjectThenPrintAttributes() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        Project project = testDataProvider.getProject(0, 0);
        List<Faq> faqs = project.getFaqs();
        List<ProjectEvent> projectEvents = project.getProjectEvents();
        when(model.getName()).thenReturn(project.getName());
        when(model.getDemoLink()).thenReturn(project.getDemoLink());
        when(model.getBalance()).thenReturn(project.getBalance());
        when(model.getGoal()).thenReturn(project.getGoal());
        when(model.getShortDescription()).thenReturn(project.getShortDescription());
        when(model.getDeadlineDate()).thenReturn(project.getDeadlineDate());
        when(model.getFaqs()).thenReturn(project.getFaqs());
        when(model.getProjectEvent()).thenReturn(project.getProjectEvents());
        when(model.isFaqExists()).thenReturn(true);
        when(model.isProjectEvenExists()).thenReturn(true);

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
        ProjectView projectView = new ProjectView(output);

        projectView.render(model);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(String.format("Project name: %s", project.getName()));
        expectedResult.add(String.format("Short Description: %s", project.getShortDescription()));
        expectedResult.add(String.format("Demo link: %s", project.getDemoLink()));
        expectedResult.add(String.format("Goal: %s", getMoney(project.getGoal())));
        expectedResult.add(String.format("Balance: %s", getMoney(project.getBalance())));
        expectedResult.add(String.format("Time left: %s", getDiffDate(model.getDeadlineDate(), new Date())));
        expectedResult.add("FAQ:");
        for (int counter = 0; counter < faqs.size(); counter++) {
            expectedResult.add(String.format("  %s. [%s]", counter + 1, faqs.get(counter).getQuestion()));
            expectedResult.add(String.format("      %s", faqs.get(counter).getAnswer()));
        }
        expectedResult.add("Project events:");
        for (ProjectEvent projectEvent : projectEvents) {
            expectedResult.add(String.format("  %s: %s", getDate(projectEvent.getEventDate()), projectEvent.getMessage()));
        }
        expectedResult.add(Utils.CHOICE_MESSAGE);

        Assert.assertArrayEquals("Not expected Project rendering", expectedResult.toArray(), view.toArray());
    }
}