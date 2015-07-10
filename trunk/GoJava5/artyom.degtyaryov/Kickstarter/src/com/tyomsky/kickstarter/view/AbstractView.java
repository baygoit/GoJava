package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.ui.Output;

import java.util.ArrayList;

public abstract class AbstractView {

    protected ArrayList<String> layout = new ArrayList<>();

    protected Output output;

    protected abstract void prepareLayout();

    public AbstractView(Output output) {
        this.output = output;
    }

    public void show() {
        prepareLayout();
        output.print(layout);
    }

}
