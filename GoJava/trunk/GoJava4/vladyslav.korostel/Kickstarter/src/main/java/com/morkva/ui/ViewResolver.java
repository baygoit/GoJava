package com.morkva.ui;

import com.morkva.ui.controllers.IController;

/**
 * Created by vladyslav on 28.05.15.
 */
public class ViewResolver {
    private static ViewResolver instance;

    private IController nextController;

    public static ViewResolver getInstance() {
        if (instance == null) {
            instance = new ViewResolver();
        }
        return instance;
    }

    public IController getNextView() {
        return nextController;
    }

    public void setNextView(IController nextController) {
        this.nextController = nextController;
    }
}
