package com.tyomsky.kickstarter.mvc.controller;


import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.mvc.model.AbstractPageModel;
import com.tyomsky.kickstarter.mvc.view.AbstractPageView;

public abstract class  AbstractController <MODEL extends AbstractPageModel, VIEW extends AbstractPageView> {

    MODEL model;
    VIEW view;

    public AbstractController(MODEL model, VIEW view) {
        this.model = model;
        this.view = view;
    }

}
