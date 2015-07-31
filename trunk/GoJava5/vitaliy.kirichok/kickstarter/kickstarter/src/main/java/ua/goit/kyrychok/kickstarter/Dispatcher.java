package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.controller.*;
import ua.goit.kyrychok.kickstarter.dao.factory.AbstractDaoFactory;
import ua.goit.kyrychok.kickstarter.view.*;

public class Dispatcher implements InputListener {
    private AbstractController currentController;

    public void init(AbstractDaoFactory daoFactory, Output output) {

        MainPageController mainPageController = new MainPageController(daoFactory.createCategory());
        mainPageController.setView(new MainPageView(output));

        CategoryController categoryController = new CategoryController(daoFactory.createCategory());
        categoryController.setView(new CategoryView(output));

        ProjectController projectController = new ProjectController(daoFactory.createProject());
        projectController.setView(new ProjectView(output));

        FaqController faqController = new FaqController(daoFactory.createFaq());
        faqController.setView(new FaqView(output));

        DonatePageController donatePageController = new DonatePageController(daoFactory.createReward());
        donatePageController.setView(new DonatePageView(output));

        PaymentView paymentView = new PaymentView(output);

        PaymentController paymentController = new PaymentController(daoFactory.createProject());
        paymentController.setView(paymentView);

        PaymentRewardController paymentRewardController = new PaymentRewardController(daoFactory.createProject(), daoFactory.createReward());
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
