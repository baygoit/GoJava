package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.ProjectEvent;

import java.util.Date;
import java.util.List;

public class ProjectModel extends BaseModel {
    private Project project;

    public void update(int categoryIndex) {
        this.project = getDataProvider().getProject(categoryIndex, getIdentifier());
    }

    public String getName() {
        return project.getName();
    }

    public String getShortDescription() {
        return project.getShortDescription();
    }

    public Integer getBalance() {
        return project.getBalance();
    }

    public Integer getGoal() {
        return project.getGoal();
    }

    public Date getDeadlineDate() {
        return project.getDeadlineDate();
    }

    public String getDemoLink() {
        return project.getDemoLink();
    }

    public boolean isFaqExists() {
        return (project.getFaqs() != null && project.getFaqs().size() > 0);
    }

    public List<Faq> getFaqs() {
        return project.getFaqs();
    }

    public boolean isProjectEvenExists() {
        return (project.getProjectEvents() != null && project.getProjectEvents().size() > 0);
    }

    public List<ProjectEvent> getProjectEvent() {
        return project.getProjectEvents();
    }
}
