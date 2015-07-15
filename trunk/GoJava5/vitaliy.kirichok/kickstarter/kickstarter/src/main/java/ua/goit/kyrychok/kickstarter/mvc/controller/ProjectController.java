package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.EXIT_CODE;
import static ua.goit.kyrychok.kickstarter.Utils.deleteLastElements;

public class ProjectController extends BaseController {
    private static final int OWN_PATH_INDEX = 3;
    private ProjectModel model;
    private ProjectView view;
    private BaseController faqController;

    public ProjectController(DataProvider dataProvider, Output output, ProjectModel model, ProjectView view) {
        super();
        this.model = model;
        this.view = view;
        faqController = new FaqController(dataProvider, output);
        faqController.setPreviousController(this);
    }

    private boolean isValid(String input) {
        boolean result = true;
        try {
            int inputValue = Integer.parseInt(input);
            if (inputValue < 1 || inputValue > 1) {
                result = false;
            }
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    private void show() {
        setNextController(this);
        setNeedNextImmediateExecute(false);
        view.render(model);
    }

    private void update(List<String> input) {
        model.update(Integer.parseInt(input.get(OWN_PATH_INDEX - 2)) - 1, Integer.parseInt(input.get(OWN_PATH_INDEX - 1)) - 1);
    }

    @Override
    public void onInput(List<String> input) {
        if (input.size() == OWN_PATH_INDEX) {
            update(input);
            show();
        } else {
            String inputValue = input.get(OWN_PATH_INDEX);
            if (inputValue.equals(EXIT_CODE)) {
                deleteLastElements(input, 2);
                setNextController(getPreviousController());
                setNeedNextImmediateExecute(true);
            } else if (isValid(inputValue)) {
                if (inputValue.equals("1")) {
                    setNextController(faqController);
                }
                setNeedNextImmediateExecute(true);
            } else {
                deleteLastElements(input, 1);
                show();
            }
        }
    }
}
