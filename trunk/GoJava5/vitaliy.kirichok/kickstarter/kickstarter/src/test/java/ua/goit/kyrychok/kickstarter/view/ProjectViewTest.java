package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.time.DateUtils.addHours;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static ua.goit.kyrychok.kickstarter.Utils.getDate;

public class ProjectViewTest {

    //TODO @Mock
    //TODO private ProjectModel model;
    @Mock
    private Output output;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenRenderProjectThenPrintAllAttributes() throws Exception {
        Project project = new Project("project", 30000, addHours(new Date(), 3));
        project.setShortDescription("desc");
        project.setBalance(215);
        project.setDemoLink("link");
        project.addFaq(new Faq("question"));
        project.addFaq(new Faq("question", "answer"));
        project.addProjectEvent(new ProjectEvent(new Date(), "text"));

        //TODO dzfasdf
//        when(model.getName()).thenReturn(project.getName());
//        when(model.getDemoLink()).thenReturn(project.getDemoLink());
//        when(model.getBalance()).thenReturn(project.getBalance());
//        when(model.getGoal()).thenReturn(project.getGoal());
//        when(model.getShortDescription()).thenReturn(project.getShortDescription());
//        when(model.getDeadlineDate()).thenReturn(project.getDeadlineDate());
//        when(model.getFaqs()).thenReturn(project.getFaqs());
//        when(model.getProjectEvent()).thenReturn(project.getProjectEvents());
//        when(model.isFaqExists()).thenReturn(true);
//        when(model.isProjectEvenExists()).thenReturn(true);

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
        ProjectView projectView = new ProjectView();
        projectView.setOutput(output);

        //TODO projectView.render(model);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(String.format("Project name: %s", project.getName()));
        expectedResult.add(String.format("Short Description: %s", project.getShortDescription()));
        expectedResult.add(String.format("Demo link: %s", project.getDemoLink()));
        //TODO expectedResult.add(String.format("Balance: %s; Goal: %s; Time left: %s", getMoney(project.getBalance()), getMoney(project.getGoal()), getDiffDate(model.getDeadlineDate(), new Date())));
        expectedResult.add("FAQ:");
        expectedResult.add("  1. <question>");
        expectedResult.add("  2. <question>");
        expectedResult.add("      answer");
        expectedResult.add("Project events:");
        expectedResult.add(String.format("  %s: %s", getDate(project.getProjectEvents().get(0).getEventDate()), project.getProjectEvents().get(0).getMessage()));
        expectedResult.add("Actions:");
        expectedResult.add("[1]. Ask a question");
        expectedResult.add("[2]. Donate");
        expectedResult.add(BaseView.CHOICE_MESSAGE);

        Assert.assertArrayEquals("Not expected Project rendering", expectedResult.toArray(), view.toArray());
    }
}