package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

public class ProjectController extends BaseController {
    private ProjectModel model;
    private ProjectView view;
    private FaqController faqController;
    private DonatePageController donatePageController;

    public void setModel(ProjectModel model) {
        this.model = model;
    }

    public void setView(ProjectView view) {
        this.view = view;
    }

    public void setFaqController(FaqController faqController) {
        this.faqController = faqController;
    }

    public void setDonatePageController(DonatePageController donatePageController) {
        this.donatePageController = donatePageController;
    }

    private boolean isValid(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return !(inputValue < 1 || inputValue > 2);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BaseController returnNextController(int input) {
        BaseController controller = null;
        if (input == 1) {
            controller = faqController;
        } else if (input == 2) {
            controller = donatePageController;
        }
        return controller;
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
            setNextController(returnNextController(Integer.parseInt(input)));
            setNeedNextImmediateExecute(true);
        }
    }
}
