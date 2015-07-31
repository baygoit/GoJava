package ua.goit.kyrychok.kickstarter.controller;

import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.view.ProjectView;

import static java.lang.Integer.parseInt;

public class ProjectController extends AbstractController {
    private Project model;
    private ProjectView view;
    private FaqController faqController;
    private DonatePageController donatePageController;
    private int projectId;
    private ProjectDao projectDao;

    public ProjectController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setModel(Project model) {
        this.model = model;
    }

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

    private AbstractController returnNextController(String input) {
        switch (parseInt(input)) {
            case 1:
                faqController.setProjectId(projectId);
                return faqController;
            case 2:
                donatePageController.setProjectId(projectId);
                return donatePageController;
            default:
                throw new IndexOutOfBoundsException("Unexpected input value: ".concat(input));
        }
    }

    @Override
    protected boolean isValid(String input) {
        try {
            int inputValue = parseInt(input);
            return !(inputValue < 1 || inputValue > 2);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void updateModel() {
        model = projectDao.load(projectId);
    }

    @Override
    protected void renderModel() {
        view.render(model);
    }

    @Override
    protected void doValidControl(String input) {
        setNextController(returnNextController(input));
    }

    @Override
    protected void showError(String input) {
    }
}
