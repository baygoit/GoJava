package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.mvc.view.ModelUpdateListener;

import java.util.List;

public class CategoryPageModel extends AbstractPageModel {

    ModelUpdateListener<CategoryPageModel> modelUpdateListener;

    private Category category;

    public CategoryPageModel(DataRegistry dataRegistry) {
        super(dataRegistry);
    }

    public void update(int categoryId) {
        category = dataRegistry.getCategoryById(categoryId);
        modelUpdateListener.onModelUpdate(this);
    }

    public String getName() {
        return category.getName();
    }

    public List<Project> getProjects() {
        return category.getProjects();
    }

    public Category getCategory() {
        return category;
    }

    public void setModelUpdateListener(ModelUpdateListener<CategoryPageModel> modelUpdateListener) {
        this.modelUpdateListener = modelUpdateListener;
    }
}
