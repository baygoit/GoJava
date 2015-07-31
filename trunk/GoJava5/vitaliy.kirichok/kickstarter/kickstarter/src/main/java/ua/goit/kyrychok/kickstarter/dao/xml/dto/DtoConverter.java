package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import ua.goit.kyrychok.kickstarter.model.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DtoConverter {

    public Category convertToDomain(DtoCategory dtoCategory) {
        Category category = new Category(dtoCategory.name);
        category.setId(parseInt(dtoCategory.id));
        category.setProjects(convertProjectsToDomain(dtoCategory.projects));
        return category;
    }

    public Project convertToDomain(DtoProject dtoProject) {
        Project project = new Project(dtoProject.name, dtoProject.goal, dtoProject.deadlineDate);
        project.setId(parseInt(dtoProject.id));
        project.setDemoLink(dtoProject.demoLink);
        project.setShortDescription(dtoProject.shortDescription);
        project.setBalance(dtoProject.balance);
        project.setProjectEvents(convertProjectEventsToDomain(dtoProject.projectEvents));
        project.setFaqs(convertFaqsToDomain(dtoProject.faqs));
        project.setRewards(convertRewardsToDomain(dtoProject.rewards));
        return project;
    }

    public Faq convertToDomain(DtoFaq dtoFaq) {
        Faq faq = new Faq(dtoFaq.question, dtoFaq.answer);
        faq.setId(parseInt(dtoFaq.id));
        return faq;
    }

    public ProjectEvent convertToDomain(DtoProjectEvent dtoProjectEvent) {
        ProjectEvent projectEvent = new ProjectEvent(dtoProjectEvent.eventDate, dtoProjectEvent.message);
        projectEvent.setId(parseInt(dtoProjectEvent.id));
        return projectEvent;
    }

    public Reward convertToDomain(DtoReward dtoReward) {
        Reward reward = new Reward(dtoReward.amount, dtoReward.description);
        reward.setId(parseInt(dtoReward.id));
        return reward;
    }

    public List<Category> convertCategoriesToDomain(List<DtoCategory> dtoCategories) {
        List<Category> categories = new ArrayList<>();
        for (DtoCategory dtoCategory : dtoCategories) {
            categories.add(convertToDomain(dtoCategory));
        }
        return categories;
    }

    public List<Project> convertProjectsToDomain(List<DtoProject> dtoProjects) {
        List<Project> projects = new ArrayList<>();
        for (DtoProject dtoProject : dtoProjects) {
            projects.add(convertToDomain(dtoProject));
        }
        return projects;
    }

    public List<ProjectEvent> convertProjectEventsToDomain(List<DtoProjectEvent> dtoProjectEvents) {
        List<ProjectEvent> projectEvents = new ArrayList<>();
        for (DtoProjectEvent dtoProjectEvent : dtoProjectEvents) {
            projectEvents.add(convertToDomain(dtoProjectEvent));
        }
        return projectEvents;
    }

    public List<Faq> convertFaqsToDomain(List<DtoFaq> dtoFaqs) {
        List<Faq> faqs = new ArrayList<>();
        for (DtoFaq dtoFaq : dtoFaqs) {
            faqs.add(convertToDomain(dtoFaq));
        }
        return faqs;
    }

    public List<Reward> convertRewardsToDomain(List<DtoReward> dtoRewards) {
        List<Reward> rewards = new ArrayList<>();
        for (DtoReward dtoReward : dtoRewards) {
            rewards.add(convertToDomain(dtoReward));
        }
        return rewards;
    }

    public DtoCategory convertToDto(Category category) {
        DtoCategory dtoCategory = new DtoCategory();
        dtoCategory.id = Integer.toString(category.getId());
        dtoCategory.name = category.getName();
        dtoCategory.projects = convertProjectsToDto(category.getProjects());
        return dtoCategory;
    }

    public DtoProject convertToDto(Project project) {
        DtoProject dtoProject = new DtoProject();
        dtoProject.balance = project.getBalance();
        dtoProject.createDate = project.getCreateDate();
        dtoProject.deadlineDate = project.getDeadlineDate();
        dtoProject.demoLink = project.getDemoLink();
        dtoProject.goal = project.getGoal();
        dtoProject.id = Integer.toString(project.getId());
        dtoProject.name = project.getName();
        dtoProject.shortDescription = project.getShortDescription();
        dtoProject.faqs = convertFaqsToDto(project.getFaqs());
        dtoProject.rewards = convertRewardsToDto(project.getRewards());
        dtoProject.projectEvents = convertProjectEventsToDto(project.getProjectEvents());
        return dtoProject;
    }

    public DtoFaq convertToDto(Faq faq) {
        DtoFaq dtoFaq = new DtoFaq();
        dtoFaq.answer = faq.getAnswer();
        dtoFaq.question = faq.getQuestion();
        dtoFaq.id = Integer.toString(faq.getId());
        return dtoFaq;
    }

    public DtoReward convertToDto(Reward reward) {
        DtoReward dtoReward = new DtoReward();
        dtoReward.amount = reward.getAmount();
        dtoReward.description = reward.getDescription();
        dtoReward.id = Integer.toString(reward.getId());
        return dtoReward;
    }

    public DtoProjectEvent convertToDto(ProjectEvent projectEvent) {
        DtoProjectEvent dtoProjectEvent = new DtoProjectEvent();
        dtoProjectEvent.eventDate = projectEvent.getEventDate();
        dtoProjectEvent.message = projectEvent.getMessage();
        dtoProjectEvent.id = Integer.toString(projectEvent.getId());
        return dtoProjectEvent;
    }

    public List<DtoCategory> convertCategoriesToDto(List<Category> categories) {
        List<DtoCategory> dtoCategories = new ArrayList<>();
        for (Category category : categories) {
            dtoCategories.add(convertToDto(category));
        }
        return dtoCategories;
    }

    public List<DtoProject> convertProjectsToDto(List<Project> projects) {
        List<DtoProject> dtoProjects = new ArrayList<>();
        for (Project project : projects) {
            dtoProjects.add(convertToDto(project));
        }
        return dtoProjects;
    }

    public List<DtoFaq> convertFaqsToDto(List<Faq> faqs) {
        List<DtoFaq> dtoFaqs = new ArrayList<>();
        for (Faq faq : faqs) {
            dtoFaqs.add(convertToDto(faq));
        }
        return dtoFaqs;
    }

    public List<DtoProjectEvent> convertProjectEventsToDto(List<ProjectEvent> projectEvents) {
        List<DtoProjectEvent> dtoProjectEvents = new ArrayList<>();
        for (ProjectEvent projectEvent : projectEvents) {
            dtoProjectEvents.add(convertToDto(projectEvent));
        }
        return dtoProjectEvents;
    }

    public List<DtoReward> convertRewardsToDto(List<Reward> rewards) {
        List<DtoReward> dtoRewards = new ArrayList<>();
        for (Reward reward : rewards) {
            dtoRewards.add(convertToDto(reward));
        }
        return dtoRewards;
    }
}
