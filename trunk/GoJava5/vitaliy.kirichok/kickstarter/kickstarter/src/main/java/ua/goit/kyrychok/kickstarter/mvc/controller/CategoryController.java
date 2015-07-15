package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;

import java.util.List;

import static ua.goit.kyrychok.kickstarter.Utils.EXIT_CODE;
import static ua.goit.kyrychok.kickstarter.Utils.deleteLastElements;

public class CategoryController extends BaseController {
    private static final int OWN_PATH_INDEX = 2;
    private CategoryModel model;
    private CategoryView view;

    public CategoryController(CategoryModel model, CategoryView view) {
        super();
        this.model = model;
        this.view = view;
    }

    private boolean isValid(String input) {
        boolean result = true;
        try {
            int inputValue = Integer.parseInt(input);
            if (inputValue < 1 || inputValue > model.getCount()) {
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
        model.update(Integer.parseInt(input.get(OWN_PATH_INDEX - 1)) - 1);
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
                setNextController(getChildController());
                setNeedNextImmediateExecute(true);
            } else {
                deleteLastElements(input, 1);
                show();
            }
        }
    }
}
