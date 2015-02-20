package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.main.Kickstarter;
import ua.com.scread.kickstarter.model.Model;
import ua.com.scread.kickstarter.storage.Categories;

public class ModelTest {

    @Test
    public void shouldInitialized_whenInitializedModel() {
        Model model = Kickstarter.demoData();
        Categories categories = model.getCategories();
        Category category = categories.get(0);
//        assertEquals("[1 - Sport, 2 - Science, 3 - Virtual reality]", Arrays.toString(model.getStringCatigories()));
        assertEquals("[]", model.getProjects(category).toString());
    }
}
