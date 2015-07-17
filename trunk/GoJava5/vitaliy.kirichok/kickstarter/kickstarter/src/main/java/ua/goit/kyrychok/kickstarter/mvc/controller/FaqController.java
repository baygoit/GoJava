package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;
import ua.goit.kyrychok.kickstarter.mvc.view.FaqView;

import java.util.regex.Pattern;

public class FaqController extends BaseController {
    public static final int MAX_QUESTION_LENGTH = 150;
    public static final Pattern questionPattern = Pattern.compile("^$");
    private FaqModel model;
    private FaqView view;

    public void setModel(FaqModel model) {
        this.model = model;
    }

    public void setView(FaqView view) {
        this.view = view;
    }

    private boolean isValid(String input) {
        return !(input == null || input.length() > MAX_QUESTION_LENGTH);
    }

    @Override
    public void showModel() {
        onShowModel();
        view.render(model);
    }

    public void setQuestion(String question) {
        int categoryIdentifier = getParentController().getParentController().getModelIdentifier();
        int projectIdentifier = getParentController().getModelIdentifier();
        model.setQuestion(categoryIdentifier, projectIdentifier, question);
    }

    @Override
    public void onInput(String input) {
        if (isExit(input)) {
            doExit();
        } else if (isValid(input)) {
            setQuestion(input);
            setNextController(getParentController());
            setNeedNextImmediateExecute(true);
        }
    }
}
