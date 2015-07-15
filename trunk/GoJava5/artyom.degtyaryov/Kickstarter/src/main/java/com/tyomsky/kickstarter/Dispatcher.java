package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.mvc.controller.CategoryController;
import com.tyomsky.kickstarter.mvc.controller.InputListener;
import com.tyomsky.kickstarter.mvc.controller.MainPageController;
import com.tyomsky.kickstarter.mvc.controller.ProjectController;
import com.tyomsky.kickstarter.mvc.model.CategoryModel;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.mvc.view.CategoryView;
import com.tyomsky.kickstarter.mvc.view.MainPageView;
import com.tyomsky.kickstarter.mvc.view.ProjectView;
import com.tyomsky.kickstarter.ui.Output;

import java.util.ArrayList;

public class Dispatcher implements InputListener {

    private ArrayList<Integer> path = new ArrayList<>();
    MainPageController mainPageController;
    CategoryController categoryController;
    ProjectController projectController;

    public Dispatcher() {
    }

    public void initControllers(Configuration configuration) {
        Output output = configuration.getOutput();
        DataProvider dataProvider = configuration.getDataProvider();
        mainPageController = new MainPageController(new MainPageView(output), new MainPageModel(dataProvider));
        categoryController = new CategoryController(new CategoryView(output), new CategoryModel(dataProvider));
        projectController = new ProjectController(new ProjectView(output), new ProjectModel(dataProvider));
    }

    @Override
    public void onInput(int input) {
        if (isExitRequest(input)) {
            System.exit(0);
        }
        updatePath(input);
        boolean dispatched = dispatch();
        if (!dispatched) {
            path.remove(path.size() - 1);
            dispatch();
        }
    }

    private boolean isExitRequest(int input) {
        boolean result = false;
        if (path.size() == 0 && input == 0) {
            result = true;
        }
        return result;
    }

    private boolean dispatch() {
        switch (path.size()) {
            case 0: {
                return mainPageController.showModel();
            }
            case 1: {
                return categoryController.showModel(path.get(0) - 1);
            }
            case 2: {
                return projectController.showModel(path.get(0) - 1, path.get(1) - 1);
            }
            default:
                return false;

        }
    }

    private boolean updatePath(int input) {
        if (input != 0 && path.size() == 2) {
            return false;
        }
        if (input == 0) {
            path.remove(path.size() - 1);
        } else {
            path.add(input);
        }
        return true;
    }

    public void onApplicationStart() {
        mainPageController.showModel();
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public void setMainPageController(MainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    public void setCategoryController(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    public void setProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

}