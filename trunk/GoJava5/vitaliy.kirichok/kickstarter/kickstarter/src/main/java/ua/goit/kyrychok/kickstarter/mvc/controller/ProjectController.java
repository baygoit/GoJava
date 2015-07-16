package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

public class ProjectController extends BaseController {
    private ProjectModel model;
    private ProjectView view;
    private BaseController faqController;

    public void setModel(ProjectModel model) {
        this.model = model;
    }

    public void setView(ProjectView view) {
        this.view = view;
    }

    public void setFaqController(BaseController faqController) {
        this.faqController = faqController;
    }

    private boolean isValid(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return !(inputValue < 1 || inputValue > 1);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void showModel() {
        model.update(getParentController().getModelIdentifier());
        onShowModel();
        view.render(model);
    }

    @Override
    public void setModelIdentifier(int identifier) {
        model.setIdentifier(identifier - 1);
    }

    @Override
    public int getModelIdentifier() {
        return model.getIdentifier();
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            BaseController controller;
            controller = faqController;
            setNextController(controller);
            setNeedNextImmediateExecute(true);
        }
    }
}
