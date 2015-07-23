package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.DataProvider;

public abstract class BaseController {
    public static final String EXIT_CODE = "0";

    private BaseController parentController;
    private BaseController childController;
    private BaseController nextController;
    private boolean needNextImmediateExecute;
    protected DataProvider dataProvider;

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public BaseController getParentController() {
        return parentController;
    }

    public void setParentController(BaseController parentController) {
        this.parentController = parentController;
    }

    public BaseController getChildController() {
        return childController;
    }

    public void setChildController(BaseController childController) {
        this.childController = childController;
    }

    public BaseController getNextController() {
        return nextController;
    }

    public void setNextController(BaseController nextController) {
        this.nextController = nextController;
    }

    public boolean isNeedNextImmediateExecute() {
        return needNextImmediateExecute;
    }

    public void setNeedNextImmediateExecute(boolean needNextImmediateExecute) {
        this.needNextImmediateExecute = needNextImmediateExecute;
    }

    public abstract void onInput(String input);

    public abstract void showModel();

    public void setModelIdentifier(int identifier) {

    }

    public int getModelIdentifier() {
        return 0;
    }

    public void onShowModel() {
        setNextController(this);
        //setNeedNextImmediateExecute(true);
    }

    public void doExit() {
        setNextController(getParentController());
        //setNeedNextImmediateExecute(true);
    }

    public boolean isExit(String input) {
        return EXIT_CODE.equals(input);
    }
}
