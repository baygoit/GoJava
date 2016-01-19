package ua.com.goit.gojava7.kickstarter.model;

import org.junit.Before;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.InMemoryCategoryStorage;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class KickstarterTest {

    @Test
    public void testDonating() throws ExitException, IOException {
        Category category = new Category("category1");
        int moneyNeeded = 200;
        Project project = new Project("project1", category, "", "", "", "", moneyNeeded, 10);
        CategoryStorage storage = new InMemoryCategoryStorage();
        storage.add(category);
        category.add(project);
        Kickstarter kickstarter = new Kickstarter(storage, null);
        Controller controller = new Controller(kickstarter);
        int moneyDonated = 100;
        controller.donate(project, moneyDonated);
        assertThat(project.getMoneyDonated(), is(moneyDonated));
        assertThat(project.getMoneyNeeded(), is(moneyNeeded - moneyDonated));
    }

    @Test
    public void testDonatingMuch() throws ExitException, IOException {
        Category category = new Category("category1");
        int moneyNeeded = 100;
        Project project = new Project("project1", category, "", "", "", "", moneyNeeded, 10);
        CategoryStorage storage = new InMemoryCategoryStorage();
        storage.add(category);
        category.add(project);
        Kickstarter kickstarter = new Kickstarter(storage, null);
        Controller controller = new Controller(kickstarter);
        int moneyDonated = 200;
        controller.donate(project, moneyDonated);
        assertThat(project.getMoneyDonated(), is(moneyDonated));
        assertThat(project.getMoneyNeeded(), is(0));
    }
}
