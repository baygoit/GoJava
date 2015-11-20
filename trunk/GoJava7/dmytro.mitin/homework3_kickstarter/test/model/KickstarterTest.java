package model;

import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Dmytro on 08.11.2015.
 */
public class KickstarterTest {

    @Test
    public void testDonating() throws ExitException {
        Category category = new Category("category1");
        Project project = new Project("project1", "", "", "", "", 100, 10);
        CategoryStorage storage = new CategoryStorage();
        storage.addCategory(category);
        storage.addProject(project, category);
        Kickstarter kickstarter = new Kickstarter(storage, null);
        Controller controller = new Controller(kickstarter);
        controller.donate(project, 200);
        assertThat(project.getMoneyDonated(), is(200));
    }
}
