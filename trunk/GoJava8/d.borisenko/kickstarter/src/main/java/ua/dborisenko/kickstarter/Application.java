package ua.dborisenko.kickstarter;

public class Application {

    public void start() {
        DataSource.fillAllProjectCategories();
        DataSource.fillAllProjects();
        DataSource.fillAllDailyPhrases();
        ControllerMain controllerMain = new ControllerMain();
        controllerMain.showMainMenu();
    }
}
