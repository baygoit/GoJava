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

    public void onInput(String input) {
        if (isExit(input)) {
            setNextController(getParentController());
        } else if (isValid(input)) {
            doValidControl(input);
        } else {
            showModel();
        }
    }

    protected abstract void updateModel();

    public void takeControl() {
        updateModel();
        showModel();
    }

    protected abstract void renderModel();

    protected void showModel() {
        setNextController(this);
        renderModel();
    }

    protected abstract boolean isValid(String input);

    protected abstract void doValidControl(String input);

    private boolean isExit(String input) {
        return EXIT_CODE.equals(input);
    }
}
