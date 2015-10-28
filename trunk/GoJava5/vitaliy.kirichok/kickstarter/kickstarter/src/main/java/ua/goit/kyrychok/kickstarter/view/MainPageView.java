package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;

public class MainPageView extends BaseView {

    public MainPageView(Output output) {
        super(output);
    }

    public void render(List<Category> model, String welcomeMessage) {
        writeLine(welcomeMessage);
        for (int counter = 0; counter < model.size(); counter++) {
            writeLine(String.format("[%s]. %s", counter + 1, model.get(counter).getName()));
        }
        writeLine(CHOICE_MESSAGE);
    }

}
