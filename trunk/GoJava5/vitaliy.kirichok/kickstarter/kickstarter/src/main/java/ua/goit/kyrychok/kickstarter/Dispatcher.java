package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.mvc.controller.*;
import ua.goit.kyrychok.kickstarter.mvc.model.CategoryModel;
import ua.goit.kyrychok.kickstarter.mvc.model.FaqModel;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;
import ua.goit.kyrychok.kickstarter.mvc.model.ProjectModel;
import ua.goit.kyrychok.kickstarter.mvc.view.CategoryView;
import ua.goit.kyrychok.kickstarter.mvc.view.FaqView;
import ua.goit.kyrychok.kickstarter.mvc.view.MainPageView;
import ua.goit.kyrychok.kickstarter.mvc.view.ProjectView;

public class Dispatcher implements InputListener {
    private BaseController currentController;

    public Dispatcher(DataProvider dataProvider, Output output) {
        MainPageController mainPageController = new MainPageController();
        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setDataProvider(dataProvider);
        MainPageView mainPageView = new MainPageView();
        mainPageView.setOutput(output);
        mainPageController.setModel(mainPageModel);
        mainPageController.setView(mainPageView);

        CategoryController categoryController = new CategoryController();
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setDataProvider(dataProvider);
        CategoryView categoryView = new CategoryView();
        categoryView.setOutput(output);
        categoryController.setModel(categoryModel);
        categoryController.setView(categoryView);

        ProjectController projectController = new ProjectController();
        ProjectModel projectModel = new ProjectModel();
        projectModel.setDataProvider(dataProvider);
        ProjectView projectView = new ProjectView();
        projectView.setOutput(output);
        projectController.setModel(projectModel);
        projectController.setView(projectView);

        FaqController faqController = new FaqController();
        FaqModel faqModel = new FaqModel();
        faqModel.setDataProvider(dataProvider);
        FaqView faqView = new FaqView();
        faqView.setOutput(output);
        faqController.setModel(faqModel);
        faqController.setView(faqView);

        mainPageController.setChildController(categoryController);
        categoryController.setChildController(projectController);
        categoryController.setParentController(mainPageController);
        projectController.setParentController(categoryController);
        projectController.setFaqController(faqController);
        faqController.setParentController(projectController);
        currentController = mainPageController;
    }

    public void onStart() {
        currentController.showModel();
    }

    @Override
    public void onInput(String input) throws StopDispatcherException {
        currentController.onInput(input);
        BaseController tempController;
        tempController = currentController.getNextController();
        if (tempController == null) {
            throw new StopDispatcherException();
        }
        if (currentController.isNeedNextImmediateExecute()) {
            tempController.showModel();
        }
        currentController = tempController;
    }
}
