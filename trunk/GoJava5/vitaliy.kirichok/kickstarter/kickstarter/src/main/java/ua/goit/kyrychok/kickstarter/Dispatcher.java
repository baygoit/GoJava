package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.mvc.controller.CategoryController;
import ua.goit.kyrychok.kickstarter.mvc.controller.MainPageController;
import ua.goit.kyrychok.kickstarter.mvc.controller.ProjectController;
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher implements InputListener {
    private List<Integer> currentPath = new ArrayList<>();
    private MainPageController mainPageController;
    private CategoryController categoryController;
    private ProjectController projectController;
    private DataProvider dataProvider;
    private Output output;

    public Dispatcher(DataProvider dataProvider, Output output) {
        this.dataProvider = dataProvider;
        this.output = output;
        MainPageModel mainPageModel = new MainPageModel(dataProvider);
        MainPageView mainPageView = new MainPageView(output);
        mainPageController = new MainPageController(mainPageModel, mainPageView);
        CategoryModel categoryModel = new CategoryModel(dataProvider);
        CategoryView categoryView = new CategoryView(output);
        categoryController = new CategoryController(categoryModel, categoryView);
        ProjectModel projectModel = new ProjectModel(dataProvider);
        ProjectView projectView = new ProjectView(output);
        projectController = new ProjectController(projectModel, projectView);
    }

    public void start() {
        mainPageController.updateModel();
    }

    private boolean dispatch() {
        switch (currentPath.size()) {
            case 0:
                return mainPageController.updateModel();
            case 1:
                return categoryController.update(currentPath.get(0));
            case 2:
                return projectController.update(currentPath.get(0), currentPath.get(1));
            default:
                output.writeLine("Array size error");//TODO Normal Action
                return false;
        }
    }

    private void addPathElement(int value) {
        currentPath.add(value);
    }

    private void removePathElement() {
        currentPath.remove(currentPath.size() - 1);
    }

    private boolean changePath(int input) throws StopDispatcherException {
        if (input == 0 && currentPath.size() == 0) {
            throw new StopDispatcherException();
        }
        if (input != 0 && currentPath.size() == 2) {
            return false;
        }
        if (input == 0) {
            removePathElement();
        } else {
            addPathElement(input);
        }
        return true;
    }

    private int parseInput(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = -1;
        }
        return result;
    }

    @Override
    public boolean onInput(String input) {
        int inputPath = parseInput(input);
        try {
            changePath(inputPath);
            if (!dispatch()) {
                removePathElement();
                dispatch();
            }
            return true;
        } catch (StopDispatcherException e) {
            return false;
        }
    }

}
