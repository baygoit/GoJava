package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.time.DateUtils.addHours;
import static ua.goit.kyrychok.kickstarter.Utils.*;

public class ProjectViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderProjectThenPrintAllAttributes() throws Exception {
        Project project = new Project("project", 30000, addHours(new Date(), 3));
        project.setShortDescription("desc");
        project.setBalance(215);
        project.setDemoLink("link");
        project.addFaq(new Faq("question"));
        project.addFaq(new Faq("question", "answer"));
        project.addProjectEvent(new ProjectEvent(new Date(), "text"));

        ProjectView projectView = new ProjectView(output);

        projectView.render(project);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(String.format("Project name: %s", project.getName()));
        expectedResult.add(String.format("Short Description: %s", project.getShortDescription()));
        expectedResult.add(String.format("Demo link: %s", project.getDemoLink()));
        expectedResult.add(String.format("Balance: %s; Goal: %s; Time left: %s", getMoney(project.getBalance()), getMoney(project.getGoal()), getDiffDate(project.getDeadlineDate(), new Date())));
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

        Assert.assertArrayEquals("Not expected Project rendering", expectedResult.toArray(), output.getResult().toArray());
    }
}