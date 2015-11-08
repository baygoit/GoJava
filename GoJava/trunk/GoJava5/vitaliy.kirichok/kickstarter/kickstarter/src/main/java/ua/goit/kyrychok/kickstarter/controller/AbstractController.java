package ua.goit.kyrychok.kickstarter.controller;

public abstract class AbstractController {
    public static final String EXIT_CODE = "0";

    private AbstractController parentController;
    private AbstractController nextController;

    protected abstract void updateModel();

    protected abstract void renderModel();

    protected abstract boolean isValid(String input);

    protected abstract void doValidControl(String input);

    protected abstract void showError(String input);

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

    public void takeControl() {
        updateModel();
        showModel();
    }

    public void onInput(String input) {
        if (isExit(input)) {
            setNextController(getParentController());
        } else if (isValid(input)) {
            doValidControl(input);
        } else {
            showError(input);
            showModel();
        }
    }

    protected void showModel() {
        setNextController(this);
        renderModel();
    }

    private boolean isExit(String input) {
        return EXIT_CODE.equals(input);
    }
}
