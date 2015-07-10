package com.tyomsky.kickstarter.model;

import com.tyomsky.kickstarter.dao.DataProvider;

public abstract class AbstractModel {

    DataProvider dataProvider;

    public AbstractModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public abstract void update(int... parameters);
}
