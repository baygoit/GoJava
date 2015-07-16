package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;

public class AbstractPageModel {

    DataRegistry dataRegistry;

    public AbstractPageModel(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }

    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}
