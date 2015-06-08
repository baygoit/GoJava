package com.morkva.ui.controllers;

import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.views.LoginView;

/**
 * Created by vladyslav on 28.05.15.
 */
public class LoginController implements IController {

    LoginView view;
    Model model;
    Printer printer;

    public LoginController(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.printer = printer;
        this.view = new LoginView(model, printer, reader, this);
    }

    @Override
    public void showView() {
        view.showContent();
    }

    @Override
    public void readInput() {
        view.readInput();
    }
}
