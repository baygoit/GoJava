package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.view.ProjectView;

import static java.lang.Integer.parseInt;

public class ProjectController extends BaseController {
    private Project model;
    private ProjectView view;
    private FaqController faqController;
    private DonatePageController donatePageController;
    private int projectId;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > 2);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BaseController returnNextController(String input) {
        switch (parseInt(input)) {
            case 1:
                faqController.setProjectId(projectId);
                return faqController;
            case 2:
                donatePageController.setProjectId(projectId);
                return donatePageController;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value");
        }
    }

    public void updateModel() {
        model = dataProvider.getProject(projectId);
    }

    @Override
    public void showModel() {
        updateModel();
        onShowModel();
        view.render(model);
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            setNextController(returnNextController(input));
        } else {
            setNextController(this);
        }
    }
}
