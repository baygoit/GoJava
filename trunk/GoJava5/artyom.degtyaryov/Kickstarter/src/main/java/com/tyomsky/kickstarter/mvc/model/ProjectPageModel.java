package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Project;
import com.tyomsky.kickstarter.mvc.view.ModelUpdateListener;

public class ProjectPageModel extends AbstractPageModel {

    ModelUpdateListener<ProjectPageModel> modelUpdateListener;

    private Project project;

    public ProjectPageModel(DataRegistry dataRegistry) {
        super(dataRegistry);
    }

    public void update(int categoryId, int projectId) {
        project = dataRegistry.getProjectById(categoryId, projectId);
        modelUpdateListener.onModelUpdate(this);
    }

    public Project getProject() {
        return project;
    }

    public void setModelUpdateListener(ModelUpdateListener<ProjectPageModel> modelUpdateListener) {
        this.modelUpdateListener = modelUpdateListener;
    }
}
