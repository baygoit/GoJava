package ua.goit.kyrychok.kickstarter.view;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.kyrychok.kickstarter.ConsoleOutput4Test;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPageViewTest {
    private ConsoleOutput4Test output = new ConsoleOutput4Test();

    @Test
    public void whenRenderMainPageThenPrintWelcomeMsgAndCategoriesList() throws Exception {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Category 1"));
        categories.add(new Category("Category 2"));
        categories.add(new Category("Category 3"));

        MainPageView mainPageView = new MainPageView(output);

        mainPageView.render(categories, "Test Msg");

        String[] expectedResult = {"Test Msg", "[1]. Category 1", "[2]. Category 2", "[3]. Category 3", BaseView.CHOICE_MESSAGE};
        Assert.assertArrayEquals("Not expected MainPage rendering", expectedResult, output.getResult().toArray());
    }
}