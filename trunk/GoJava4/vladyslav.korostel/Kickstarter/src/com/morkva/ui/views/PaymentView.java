package com.morkva.ui.views;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.IController;
import com.morkva.ui.controllers.PaymentController;
import com.morkva.ui.controllers.ProjectController;
import com.morkva.utils.PaymentOption;

import java.util.Map;

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
        for (Map.Entry<Integer, PaymentOption> entry : project.getPaymentOptions().entrySet()) {
            printer.print(entry.getKey() + ": " + entry.getValue().getAmount() + " - " + entry.getValue().getDescription() + "\n");
        }
        printer.print("Or you can invest more money!\n");
        printer.print("0 to return\n");
    }

    @Override
    public IController readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (model.getCurrentProject().getPaymentOptions().containsKey(keyCode)) {
                controller.investToTheProject(model.getCurrentProject().getPaymentOptions().get(keyCode).getAmount());
                return new ProjectController(printer, model, reader);
            } else if (keyCode == 0){
                return new ProjectController(printer, model, reader);
            } else if (keyCode > 0){
                controller.investToTheProject(keyCode);
                return new ProjectController(printer, model, reader);
            } else {
                printer.print("Wrong Code!");
            }
        }
    }
}
