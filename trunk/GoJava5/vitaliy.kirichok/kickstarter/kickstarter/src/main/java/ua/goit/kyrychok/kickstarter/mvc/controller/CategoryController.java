package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;

public class CategoryController extends BaseController {
    private CategoryModel model;
    private CategoryView view;

    public void setModel(CategoryModel model) {
        this.model = model;
    }

    public void setView(CategoryView view) {
        this.view = view;
    }

    private boolean isValid(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return !(inputValue < 1 || inputValue > model.getCount());
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void showModel() {
        model.update();
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
            BaseController controller = getChildController();
            controller.setModelIdentifier(Integer.parseInt(input));
            setNextController(controller);
            setNeedNextImmediateExecute(true);
        }
    }
}
