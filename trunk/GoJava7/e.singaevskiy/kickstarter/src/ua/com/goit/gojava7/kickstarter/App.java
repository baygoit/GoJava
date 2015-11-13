package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.MainPageController;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public class App {

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        MainPage page = new MainPage(System.out);
        MainPageController controller = new MainPageController(page, System.in);
        controller.showMainPage();

    }

}
