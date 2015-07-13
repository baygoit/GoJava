package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.AbstractModel;
import com.tyomsky.kickstarter.ui.Output;

import java.util.ArrayList;

public abstract class AbstractView {

    protected ArrayList<String> layout = new ArrayList<>();

    protected Output output;

    protected abstract void prepareLayout(AbstractModel model);

    public AbstractView(Output output) {
        this.output = output;
    }

    public void show(AbstractModel model) {
        prepareLayout(model);
        output.print(layout);
    }

}
