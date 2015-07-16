package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.ui.Output;

public abstract class AbstractPageView<MODEL> {

    protected Output output;

    public AbstractPageView(Output output) {
        this.output = output;
    }

    public abstract void render(MODEL model);

}
