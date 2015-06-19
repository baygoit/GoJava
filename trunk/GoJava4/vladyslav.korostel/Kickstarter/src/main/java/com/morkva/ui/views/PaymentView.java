package com.morkva.ui.views;

import com.morkva.entities.PaymentOption;
import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewResolver;
import com.morkva.ui.controllers.PaymentController;
import com.morkva.ui.controllers.ProjectController;

/**
 * Created by vladyslav on 29.05.15.
 */
public class PaymentView implements IView {

    Model model;
    Printer printer;
    Reader reader;
    PaymentController controller;

    public PaymentView(Model model, Printer printer, Reader reader, PaymentController controller) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
        this.controller = controller;
    }

    @Override
    public void showContent() {
        printer.print("How much do you want to invest?\n");
        Project project = model.getCurrentProject();
        int i = 1;
        for (PaymentOption paymentOption : model.getPaymentOptionsForProject(project)) {
            printer.print(i + ": " + paymentOption.getAmount() + " - " + paymentOption.getDescription() + "\n");
            i++;
        }
        printer.print("Or you can invest more money!\n");
        printer.print("0 to return\n");
    }

    @Override
    public void readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 0){
                ViewResolver.getInstance().setNextView(new ProjectController(printer, model, reader));
                break;
            } else if (model.getPaymentOptionsForProject(model.getCurrentProject()).get(keyCode-1) != null) {
                System.err.println("HERE");
                controller.investToTheProject(model.getPaymentOptionsForProject(model.getCurrentProject()).get(keyCode-1).getAmount());
                ViewResolver.getInstance().setNextView(new ProjectController(printer, model, reader));
                break;
            } else if (keyCode > 0){
                controller.investToTheProject(keyCode);
                ViewResolver.getInstance().setNextView(new ProjectController(printer, model, reader));
                break;
            } else {
                printer.print("Wrong Code!");
            }
        }
    }
}
