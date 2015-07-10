package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.controller.AbstractController;
import com.tyomsky.kickstarter.controller.CategoryController;
import com.tyomsky.kickstarter.controller.MainPageController;
import com.tyomsky.kickstarter.controller.ProjectController;
import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.model.CategoryModel;
import com.tyomsky.kickstarter.model.MainPageModel;
import com.tyomsky.kickstarter.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.view.CategoryView;
import com.tyomsky.kickstarter.view.MainPageView;
import com.tyomsky.kickstarter.view.ProjectView;

public class Configuration {

    public Output output;
    public DataProvider dataProvider;

    public AbstractController getControllersConfiguration(){
//        todo: think about var names
        MainPageModel mpm = new MainPageModel(dataProvider);
        MainPageController mpc = new MainPageController(new MainPageView(mpm, output), mpm);
        CategoryModel cm = new CategoryModel(dataProvider);
        CategoryController cc = new CategoryController(new CategoryView(cm, output), cm);
        mpc.setChild(cc);
        cc.setParent(mpc);
        ProjectModel pm = new ProjectModel(dataProvider);
        ProjectController pc = new ProjectController(new ProjectView(pm, output), pm);
        cc.setChild(pc);
        pc.setParent(cc);
        return mpc;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
}
