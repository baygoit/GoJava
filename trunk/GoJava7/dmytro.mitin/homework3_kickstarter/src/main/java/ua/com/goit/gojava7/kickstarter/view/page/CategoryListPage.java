package ua.com.goit.gojava7.kickstarter.view.page;

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
        return new GreetingPage(view).getUpdated(command);
    }
}
