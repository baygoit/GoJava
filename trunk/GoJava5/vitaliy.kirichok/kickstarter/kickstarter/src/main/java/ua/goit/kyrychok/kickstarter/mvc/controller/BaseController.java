package ua.goit.kyrychok.kickstarter.mvc.controller;

import java.util.List;

public abstract class BaseController {
    private BaseController previousController;
    private BaseController childController;
    private BaseController nextController;
    private boolean needNextImmediateExecute;

    public BaseController getPreviousController() {
        return previousController;
    }

    public void setPreviousController(BaseController previousController) {
        this.previousController = previousController;
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

    public abstract void onInput(List<String> input);
}
