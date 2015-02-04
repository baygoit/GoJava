package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ModelTest {

    @Test
    public void shouldInitialized_whenInitializedModel() {
        Model model = new Model();
        model.init();
        Categories categories = model.getCategories();
        Category category = categories.getCategory(0);
        assertEquals("[1 - Sport, 2 - Science, 3 - Virtual reality]", Arrays.toString(model.getStringCatigories()));
        assertEquals("[]", model.getProjects(category).toString());
    }
}
