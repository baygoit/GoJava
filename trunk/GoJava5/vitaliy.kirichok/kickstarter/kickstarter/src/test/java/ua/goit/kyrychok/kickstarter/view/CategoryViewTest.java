package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;
import ua.goit.kyrychok.kickstarter.Utils;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;
import static org.apache.commons.lang3.time.DateUtils.*;
import static ua.goit.kyrychok.kickstarter.Utils.getMoney;

public class CategoryViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderCategoryThenPrintNameAndProjectsList() throws Exception {
        final int goal = 10000;
        final int balance = 1000;
        final int timeLag = 5;
        Category category = new Category("Test Category");

        Project project1 = new Project("1st project", goal, addMinutes(new Date(), timeLag));
        category.addProject(project1);

        Project project2 = new Project("2nd project", goal, addDays(new Date(), timeLag));
        project2.setShortDescription("desc");
        category.addProject(project2);

        Project project3 = new Project("3rd project", goal, addHours(new Date(), timeLag));
        project3.setShortDescription("desc");
        project3.setBalance(balance);
        category.addProject(project3);

        CategoryView categoryView = new CategoryView(output);

        categoryView.render(category);

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Test Category");

        expectedResult.add("[1]. 1st project");
        expectedResult.add(format("     Goal: %s", getMoney(project1.getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(project1.getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(project1.getDeadlineDate(), new Date())));

        expectedResult.add("[2]. 2nd project");
        expectedResult.add(format("     Short Description: %s", "desc"));
        expectedResult.add(format("     Goal: %s", getMoney(project2.getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(project2.getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(project2.getDeadlineDate(), new Date())));

        expectedResult.add("[3]. 3rd project");
        expectedResult.add(format("     Short Description: %s", "desc"));
        expectedResult.add(format("     Goal: %s", getMoney(project3.getGoal())));
        expectedResult.add(format("     Balance: %s", getMoney(project3.getBalance())));
        expectedResult.add(format("     Time left: %s", Utils.getDiffDate(project3.getDeadlineDate(), new Date())));

        expectedResult.add(BaseView.CHOICE_MESSAGE);
        Assert.assertArrayEquals("Not expected Category rendering", expectedResult.toArray(), output.getResult().toArray());
    }
}