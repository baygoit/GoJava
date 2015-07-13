package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.view.AbstractView;

public abstract class AbstractController {

    protected AbstractView view;

    protected int currentIndex;

    private AbstractController parent;

    private AbstractController child;

    public AbstractController(AbstractView view) {
        this.view = view;
    }

    public AbstractController getParent() {
        return parent;
    }

    public void setParent(AbstractController parent) {
        this.parent = parent;
    }

    public AbstractController getChild() {
        return child;
    }

    public void setChild(AbstractController child) {
        this.child = child;
    }

    public abstract void showModel(int...parameters);

    public abstract void processInput(int input);

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}