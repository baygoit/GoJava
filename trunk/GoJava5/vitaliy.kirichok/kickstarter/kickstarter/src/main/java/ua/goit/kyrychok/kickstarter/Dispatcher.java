package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.mvc.controller.*;
import ua.goit.kyrychok.kickstarter.mvc.model.*;
import ua.goit.kyrychok.kickstarter.mvc.view.*;

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

        PaymentController paymentController = new PaymentController();
        PaymentView paymentView = new PaymentView();
        paymentView.setOutput(output);
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setDataProvider(dataProvider);
        paymentController.setModel(paymentModel);
        paymentController.setView(paymentView);

        DonatePageController donatePageController = new DonatePageController();
        DonatePageView donatePageView = new DonatePageView();
        donatePageView.setOutput(output);
        DonatePageModel donatePageModel = new DonatePageModel();
        donatePageModel.setDataProvider(dataProvider);
        donatePageController.setModel(donatePageModel);
        donatePageController.setView(donatePageView);

        mainPageController.setChildController(categoryController);
        categoryController.setChildController(projectController);
        categoryController.setParentController(mainPageController);
        projectController.setParentController(categoryController);
        projectController.setFaqController(faqController);
        projectController.setDonatePageController(donatePageController);
        faqController.setParentController(projectController);
        paymentController.setParentController(projectController);
        donatePageController.setParentController(projectController);
        donatePageController.setPaymentController(paymentController);

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
