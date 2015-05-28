package com.morkva.ui;

import com.morkva.ui.views.IView;

/**
 * Created by vladyslav on 28.05.15.
 */
public class ViewResolver {
    private static ViewResolver instance;

    private ViewType nextView;

    public static ViewResolver getInstance() {
        if (instance == null) {
            instance = new ViewResolver();
        }
        return instance;
    }

    public ViewType getNextView() {
        return nextView;
    }

    public void setNextView(ViewType nextView) {
        this.nextView = nextView;
    }
}
