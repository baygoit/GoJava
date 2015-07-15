package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;
import ua.goit.kyrychok.kickstarter.mvc.view.FaqView;

import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.EXIT_CODE;
import static ua.goit.kyrychok.kickstarter.Utils.deleteLastElements;

public class FaqController extends BaseController {
    private static final int OWN_PATH_INDEX = 4;
    private FaqModel model;
    private FaqView view;

    public FaqController(DataProvider dataProvider, Output output) {
        super();
        model = new FaqModel(dataProvider);
        view = new FaqView(output);
    }

    private boolean isValid(String input) {
        boolean result = true;
        if (input.length() > 5) {
            result = false;
        }
        return result;
    }

    private void show() {
        setNextController(this);
        setNeedNextImmediateExecute(false);
        view.render(model);
    }

    @Override
    public void onInput(List<String> input) {
        if (input.size() == OWN_PATH_INDEX) {
            show();
        } else {
            String inputValue = input.get(OWN_PATH_INDEX);
            if (inputValue.equals(EXIT_CODE)) {
                deleteLastElements(input, 2);
                setNextController(getPreviousController());
                setNeedNextImmediateExecute(true);
            } else if (isValid(inputValue)) {
                model.setQuestion(Integer.parseInt(input.get(OWN_PATH_INDEX - 3)) - 1, Integer.parseInt(input.get(OWN_PATH_INDEX - 2)) - 1, inputValue);
                deleteLastElements(input, 2);
                setNextController(getPreviousController());
                setNeedNextImmediateExecute(true);
            } else {
                deleteLastElements(input, 1);
                show();
            }
        }
    }
}
