package ua.goit.kyrychok.kickstarter.mvc.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.TestDataProvider;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ProjectModelTest {

    @Mock
    private DataProvider dataProvider;

    @InjectMocks
    private ProjectModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenReturnSameProject() throws Exception {
        TestDataProvider testDataProvider = new TestDataProvider();
        testDataProvider.init();
        Project project = testDataProvider.getProject(0, 0);
        when(dataProvider.getProject(anyInt(), anyInt())).thenReturn(project);

        model.update(-1);
        List<Faq> resultFaqs = model.getFaqs();
        List<ProjectEvent> resultProjectEvents = model.getProjectEvent();

        Assert.assertEquals("Project name must be the same as registered", project.getName(), model.getName());
        Assert.assertEquals("Project description must be the same as registered", project.getShortDescription(), model.getShortDescription());
        Assert.assertEquals("Project demoLink must be the same as registered", project.getDemoLink(), model.getDemoLink());
        Assert.assertEquals("Project balance must be the same as registered", project.getBalance(), model.getBalance());
        Assert.assertEquals("Project deadlineDate must be the same as registered", project.getDeadlineDate(), model.getDeadlineDate());
        Assert.assertEquals("Project goal must be the same as registered", project.getGoal(), model.getGoal());
        Assert.assertArrayEquals("FAQs must be the same as registered", project.getFaqs().toArray(), resultFaqs.toArray());
        Assert.assertArrayEquals("Project Events must be the same as registered", project.getProjectEvents().toArray(), resultProjectEvents.toArray());
    }
}