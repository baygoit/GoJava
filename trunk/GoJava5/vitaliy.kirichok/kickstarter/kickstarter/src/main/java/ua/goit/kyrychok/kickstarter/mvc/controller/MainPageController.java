package ua.goit.kyrychok.kickstarter.mvc.controller;

import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;

public class MainPageController extends BaseController {
    private MainPageModel model;
    private MainPageView view;

    public void setModel(MainPageModel model) {
        this.model = model;
    }

    public void setView(MainPageView view) {
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
