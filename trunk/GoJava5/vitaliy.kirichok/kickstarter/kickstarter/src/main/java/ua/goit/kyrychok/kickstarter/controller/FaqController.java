package ua.goit.kyrychok.kickstarter.controller;

import org.apache.commons.lang3.StringUtils;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.view.FaqView;

public class FaqController extends AbstractController {
    public static final int MAX_QUESTION_LENGTH = 150;

    private FaqView view;
    private int projectId;

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setView(FaqView view) {
        this.view = view;
    }

    private boolean isValid(String input) {
        return !(StringUtils.isBlank(input) || input.length() > MAX_QUESTION_LENGTH);
    }

    @Override
    public void showModel() {
        onShowModel();
        view.render();
    }

    public void updateModel(String question) {
        Faq faq = new Faq(question);
        dataProvider.addFaq(projectId, faq);
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            updateModel(input);
            setNextController(getParentController());
        } else {
            setNextController(this);
        }
    }
}
