package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.controller.*;
import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.view.*;

public class Dispatcher implements InputListener {
    private AbstractController currentController;

    public void init(DataProvider dataProvider, Output output) {
        MainPageController mainPageController = new MainPageController(dataProvider);
        mainPageController.setView(new MainPageView(output));

        CategoryController categoryController = new CategoryController(dataProvider);
        categoryController.setView(new CategoryView(output));

        ProjectController projectController = new ProjectController(dataProvider);
        projectController.setView(new ProjectView(output));

        FaqController faqController = new FaqController(dataProvider);
        faqController.setView(new FaqView(output));

        DonatePageController donatePageController = new DonatePageController(dataProvider);
        donatePageController.setView(new DonatePageView(output));

        PaymentView paymentView = new PaymentView(output);

        PaymentController paymentController = new PaymentController(dataProvider);
        paymentController.setView(paymentView);

        PaymentRewardController paymentRewardController = new PaymentRewardController(dataProvider);
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
    public void onInput(String input) {
        currentController.onInput(input);
        AbstractController tempController;
        tempController = currentController.getNextController();
        if (tempController == null) {
            throw new IllegalStateException("Unable to process input because application already stopped");
        }
        if (currentController != tempController) {
            currentController = tempController;
            currentController.takeControl();
        }
    }
}
