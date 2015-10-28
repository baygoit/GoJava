package ua.com.goit.kyrychok.model;

import ua.com.goit.kyrychok.Utils;
import ua.com.goit.kyrychok.domain.Project;
import ua.com.goit.kyrychok.domain.ProjectEvent;
import ua.com.goit.kyrychok.domain.Reward;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {

    public static ProjectEventModel convert(ProjectEvent projectEvent) {
        ProjectEventModel result = new ProjectEventModel();
        result.eventDate = Utils.getDate(projectEvent.getEventDate());
        result.id = projectEvent.getId();
        result.message = projectEvent.getMessage();
        return result;
    }

    public static List<ProjectEventModel> convertProjectEvents(List<ProjectEvent> projectEvents) {
        List<ProjectEventModel> result = new ArrayList<>();
        for (ProjectEvent projectEvent : projectEvents) {
            result.add(convert(projectEvent));
        }
        return result;
    }

    public static RewardModel convert(Reward reward) {
        RewardModel result = new RewardModel();
        result.amount = Utils.getMoney(reward.getAmount());
        result.description = reward.getDescription();
        result.id = reward.getId();
        return result;
    }

    public static List<RewardModel> convertRewards(List<Reward> rewards) {
        List<RewardModel> result = new ArrayList<>();
        for (Reward reward : rewards) {
            result.add(convert(reward));
        }
        return result;
    }

    public static ProjectModel convert(Project project) {
        ProjectModel result = new ProjectModel();
        result.id = project.getId();
        result.balance = Utils.getMoney(project.getBalance());
        result.goal = Utils.getMoney(project.getGoal());
        result.name = project.getName();
        result.shortDescription = project.getShortDescription();
        result.timeLeft = Utils.getDiffDate(project.getDeadlineDate(), new Date());
        result.demoLink = project.getDemoLink();
        return result;
    }

    public static List<ProjectModel> convertProjects(List<Project> projects) {
        List<ProjectModel> result = new ArrayList<>();
        for (Project project : projects) {
            result.add(convert(project));
        }
        return result;
    }
}