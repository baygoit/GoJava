package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.mvc.controller.CategoryController;
import com.tyomsky.kickstarter.mvc.controller.MainPageController;
import com.tyomsky.kickstarter.mvc.controller.ProjectController;
import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.mvc.model.CategoryModel;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.view.CategoryView;
import com.tyomsky.kickstarter.mvc.view.MainPageView;
import com.tyomsky.kickstarter.mvc.view.ProjectView;

public class Configuration {

    public Output output;
    public DataProvider dataProvider;

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public Output getOutput() {
        return output;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }
}
