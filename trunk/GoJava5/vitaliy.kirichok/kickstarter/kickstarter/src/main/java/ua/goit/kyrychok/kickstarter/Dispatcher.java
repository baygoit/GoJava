package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.mvc.controller.BaseController;
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
    private List<String> currentPath = new ArrayList<>();
    private MainPageController mainPageController;
    private CategoryController categoryController;
    private ProjectController projectController;
    private DataProvider dataProvider;
    private Output output;
    private BaseController currentController;

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
        projectController = new ProjectController(dataProvider, output, projectModel, projectView);
        mainPageController.setChildController(categoryController);
        categoryController.setChildController(projectController);
        categoryController.setPreviousController(mainPageController);
        projectController.setPreviousController(categoryController);
        currentController = mainPageController;
    }

    public void onStart() {
        try {
            onInput("-1");
        } catch (StopDispatcherException e) {
            e.printStackTrace();//TODO do something
        }
    }

    @Override
    public void onInput(String input) throws StopDispatcherException {
        currentPath.add(input);
        boolean needRepeat = false;
        BaseController tempController;
        do {
            currentController.onInput(currentPath);
            tempController = currentController.getNextController();
            if (tempController == null) {
                throw new StopDispatcherException();
            }
            needRepeat = currentController.isNeedNextImmediateExecute();
            currentController = tempController;
        } while (needRepeat);
    }
}
