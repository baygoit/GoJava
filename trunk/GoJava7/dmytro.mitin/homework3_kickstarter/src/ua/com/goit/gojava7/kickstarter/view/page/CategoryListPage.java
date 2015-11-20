package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;

public class CategoryListPage implements Page {
    ConsoleView view;

    public CategoryListPage(ConsoleView view) {
        this.view = view;
    }

    @Override
    public void show() {
        view.printCategories();

        System.out.println();

        remindToChoose();
    }

    @Override
    public void remindToChoose() {
        System.out.println("Please choose category number or enter \"h\" for help.");
    }

    @Override
    public Page getUpdated(String command) {
        if (ConsoleView.isStandard(command)) {
            return view.updatePageToStandard(command);
        }
        int code;
        try {
            code = Integer.parseInt(command) - 1;
        } catch (NumberFormatException | NullPointerException e) {
            return new ErrorPage(view);
        }
        Category category = view.getController().getCategory(code);
        if (category == null) {
            return new ErrorPage(view);
        }
        return new CategoryPage(view, category);
    }
}
