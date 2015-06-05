package com.morkva.ui.views;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.controllers.CategoriesController;
import com.morkva.ui.controllers.IController;
import com.morkva.ui.controllers.LoginController;
import com.morkva.utils.UserType;

/**
 * Created by vladyslav on 28.05.15.
 */
public class LoginView implements IView {

    Model model;
    Printer printer;
    Reader reader;
    LoginController controller;

    public LoginView(Model model, Printer printer, Reader reader, LoginController controller) {
        this.model = model;
        this.printer = printer;
        this.reader = reader;
        this.controller = controller;
    }

    @Override
    public void showContent() {
        printer.print("Welcome to kickstarter!\n");
        printer.print("Please select login type:\n");
        printer.print("1. Admin\n");
        printer.print("2. Guest\n");
    }

    @Override
    public IController readInput() {
        while (true) {
            int keyCode = reader.readUserInput();
            if (keyCode == 1) {
                //TODO Realise admin!
                System.err.println("Not Realised!");
            } else if (keyCode == 2) {
                model.setCurrentUserType(UserType.GUEST);
                return new CategoriesController(model, reader, printer);
            }
        }
    }
}
