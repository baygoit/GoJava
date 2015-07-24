package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.controller.*;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.view.*;

public class Dispatcher implements InputListener {
    private AbstractController currentController;

    public void init(DataProvider dataProvider, Output output) {
        MainPageController mainPageController = new MainPageController();
        mainPageController.setDataProvider(dataProvider);
        MainPageView mainPageView = new MainPageView();
        mainPageView.setOutput(output);
        mainPageController.setView(mainPageView);

        CategoryController categoryController = new CategoryController();
        categoryController.setDataProvider(dataProvider);
        CategoryView categoryView = new CategoryView();
        categoryView.setOutput(output);
        categoryController.setView(categoryView);

        ProjectController projectController = new ProjectController();
        projectController.setDataProvider(dataProvider);
        ProjectView projectView = new ProjectView();
        projectView.setOutput(output);
        projectController.setView(projectView);

        FaqController faqController = new FaqController();
        faqController.setDataProvider(dataProvider);
        FaqView faqView = new FaqView();
        faqView.setOutput(output);
        faqController.setView(faqView);

        DonatePageController donatePageController = new DonatePageController();
        donatePageController.setDataProvider(dataProvider);
        DonatePageView donatePageView = new DonatePageView();
        donatePageView.setOutput(output);
        donatePageController.setView(donatePageView);

        PaymentController paymentController = new PaymentController();
        paymentController.setDataProvider(dataProvider);
        PaymentView paymentView = new PaymentView();
        paymentView.setOutput(output);
        paymentController.setView(paymentView);

        PaymentRewardController paymentRewardController = new PaymentRewardController();
        paymentRewardController.setDataProvider(dataProvider);
        paymentRewardController.setView(paymentView);

        paymentRewardController.setParentController(projectController);
        donatePageController.setPaymentRewardController(paymentRewardController);
        paymentController.setParentController(projectController);
        donatePageController.setPaymentController(paymentController);
        donatePageController.setParentController(projectController);
        faqController.setParentController(projectController);
        projectController.setDonatePageController(donatePageController);
        projectController.setFaqController(faqController);
        projectController.setParentController(categoryController);
        categoryController.setProjectController(projectController);
        categoryController.setParentController(mainPageController);
        mainPageController.setCategoryController(categoryController);

        currentController = mainPageController;
    }

    public void onStart() {
        currentController.takeControl();
    }

    @Override
    public void onInput(String input) throws EmptyDispatcherException {
        currentController.onInput(input);
        AbstractController tempController;
        tempController = currentController.getNextController();
        if (tempController == null) {
            throw new EmptyDispatcherException();
        }
        if (currentController != tempController) {
            currentController = tempController;
            currentController.takeControl();
        }
    }
}
