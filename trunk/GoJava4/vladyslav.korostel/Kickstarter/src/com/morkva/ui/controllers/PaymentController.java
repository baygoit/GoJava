package com.morkva.ui.controllers;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewType;
import com.morkva.ui.views.PaymentView;

/**
 * Created by vladyslav on 29.05.15.
 */
public class PaymentController implements IController{

    Model model;
    PaymentView view;

    public PaymentController(Model model, Printer printer, Reader reader) {
        this.model = model;
        this.view = new PaymentView(model, printer, reader, this);
    }

    public void investToTheProject(int amount) {
        Project project = model.getCurrentProject();
        project.setCurrentMoney(project.getCurrentMoney() + amount);
        project.setNeedMoney(project.getNeedMoney() - amount);
    }

    @Override
    public void showView() {
        view.showContent();
    }

    @Override
    public ViewType readInput() {
        return view.readInput();
    }
}
