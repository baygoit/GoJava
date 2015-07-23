package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;

public abstract class AbstractController {
    public static final String EXIT_CODE = "0";

    private AbstractController parentController;
    private AbstractController nextController;
    protected DataProvider dataProvider;

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public AbstractController getParentController() {
        return parentController;
    }

    public void setParentController(AbstractController parentController) {
        this.parentController = parentController;
    }

    public AbstractController getNextController() {
        return nextController;
    }

    public void setNextController(AbstractController nextController) {
        this.nextController = nextController;
    }

    public abstract void onInput(String input);

    public abstract void showModel();

    public void onShowModel() {
        setNextController(this);
    }

    public void doExit() {
        setNextController(getParentController());
    }

    public boolean isExit(String input) {
        return EXIT_CODE.equals(input);
    }
}
