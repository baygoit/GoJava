package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;

import java.util.List;

public class MainPageView extends BaseView {

    public void render(MainPageModel model) {
        getOutput().writeLine(model.getWelcomeMessage());
        List<Category> categories = model.getCategories();
        for (int counter = 0; counter < categories.size(); counter++) {
            getOutput().writeLine(String.format("[%s]. %s", counter + 1, categories.get(counter).getName()));
        }
        getOutput().writeLine(CHOICE_MESSAGE);
    }

}
