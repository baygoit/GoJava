package com.morkva.ui.controllers;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;
import com.morkva.ui.Model;
import com.morkva.ui.ViewType;
import com.morkva.ui.views.ProjectView;

/**
 * Created by vladyslav on 22.05.15.
 */
public class ProjectController implements IController{

    private Model model;
    private ProjectView view;

    public ProjectController(Printer printer, Model model, Reader reader) {
        this.view = new ProjectView(model, printer, reader, this);
        this.model = model;
    }

    public void showView() {
        view.showContent();
    }

    public ViewType readInput() {
        return view.readInput();
    }

    public void investToTheProject(int amount) {
        Project project = model.getCurrentProject();
        project.setCurrentMoney(project.getCurrentMoney() + amount);
        project.setNeedMoney(project.getNeedMoney() - amount);
    }
}
