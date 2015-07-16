package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.mvc.controller.CategoryController;
import com.tyomsky.kickstarter.mvc.controller.InputListener;
import com.tyomsky.kickstarter.mvc.controller.MainPageController;
import com.tyomsky.kickstarter.mvc.controller.ProjectController;
import com.tyomsky.kickstarter.mvc.model.CategoryPageModel;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.model.ProjectPageModel;
import com.tyomsky.kickstarter.mvc.view.CategoryPageView;
import com.tyomsky.kickstarter.mvc.view.MainPageView;
import com.tyomsky.kickstarter.mvc.view.ProjectPageView;
import com.tyomsky.kickstarter.ui.Output;


public class Dispatcher implements InputListener {

    Position currentPosition;
    MainPageController mainPageController;
    CategoryController categoryController;
    ProjectController projectController;

    public Dispatcher() {
    }

    public void initEnviroment(Configuration configuration) {
        Output output = configuration.getOutput();
        DataRegistry dataProvider = configuration.getDataProvider();

        MainPageModel mainPageModel = new MainPageModel(dataProvider);
        MainPageView mainPageView = new MainPageView(output);
        mainPageModel.setModelUpdateListener(mainPageView);
        mainPageController = new MainPageController(mainPageModel, mainPageView);

        CategoryPageModel categoryPageModel = new CategoryPageModel(dataProvider);
        CategoryPageView categoryPageView = new CategoryPageView(output);
        categoryPageModel.setModelUpdateListener(categoryPageView);
        categoryController = new CategoryController(categoryPageModel, categoryPageView);

        ProjectPageModel projectPageModel = new ProjectPageModel(dataProvider);
        ProjectPageView projectPageView = new ProjectPageView(output);
        projectPageModel.setModelUpdateListener(projectPageView);
        projectController = new ProjectController(projectPageModel, projectPageView);
    }

    @Override
    public void onInput(int... input) {
        if (input.length < 1) {
            return;
        }
        if (isExitRequest(input[0])) {
            System.exit(0);
        }
        dispatch(input[0]);
    }

    private boolean isExitRequest(int input) {
        boolean result = false;
        if (currentPosition == Position.MAIN_PAGE && input == 0) {
            result = true;
        }
        return result;
    }

    private void dispatch(int input) {
        switch (currentPosition) {
            case MAIN_PAGE: {
                if (input != 0) {
                    categoryController.onInput(input);
                    currentPosition = Position.CATEGORY_PAGE;
                    currentPosition.setContentId(input);
                } else {
                    //impossibru
                    //todo exit page
                }
                break;
            }
            case CATEGORY_PAGE: {
                if (input != 0) {
                    projectController.onInput(currentPosition.getContentId(), input);
                    currentPosition = Position.PROJECT_PAGE;
                    currentPosition.setContentId(input);
                } else {
                    currentPosition = Position.MAIN_PAGE;
                    mainPageController.onInput();
                }
                break;
            }
            case PROJECT_PAGE: {
                if (input != 0) {
                    // will be soon...
                } else {
                    currentPosition = Position.CATEGORY_PAGE;
                    categoryController.onInput(currentPosition.getContentId());
                }
                break;
            }
            default:
                break;

        }
    }

    public void onApplicationStart() {
        mainPageController.onInput();
        currentPosition = Position.MAIN_PAGE;
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