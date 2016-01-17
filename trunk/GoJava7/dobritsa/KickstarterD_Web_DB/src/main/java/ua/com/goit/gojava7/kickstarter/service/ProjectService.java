package ua.com.goit.gojava7.kickstarter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dto.ProjectDto;
import ua.com.goit.gojava7.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaymentDao paymentDao;

    public List<ProjectDto> getShortProjectsByCategory(Long categoryId) {
        List<ProjectDto> projectsDto = new ArrayList<>();

        for(Project project : projectDao.getByCategory(categoryId))
            projectsDto.add(getShortProject(project));

        return projectsDto;
    }

    public ProjectDto getShortProject(Project project) {
        log.info("<ProjectDto> getShortProject(projectId = {})...", project.getProjectId());
        //TODO if(project!=null)

        return constuctShortProjectDto(project);
    }

    public ProjectDto getFullProject(Long projectId) {
        log.info("<ProjectDto> getFullProject(projectId = {})...", projectId);

        Project project = projectDao.get(projectId);

        return constuctFullProjectDto(project);
    }

    private ProjectDto constuctShortProjectDto(Project project) {
        log.info("<ProjectDto> constuctProjectDto({})...", project);

        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(project.getProjectId());
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setGoal(project.getGoal());
        projectDto.setDaysToGo(project.getDaysToGo());

        projectDto.setPledged(paymentDao.calculatePledgedForProject(project.getProjectId()));
        log.info("<ProjectDto> constuctProjectDto(projectId = {}) set pledged = {}", project.getProjectId(),
                projectDto.getPledged());

        return projectDto;
    }

    private ProjectDto constuctFullProjectDto(Project project) {
        log.info("<ProjectDto> constuctProjectDto({})...", project);

        ProjectDto projectDto = constuctShortProjectDto(project);

        projectDto.setHistory(project.getHistory());
        projectDto.setLink(project.getLink());

        projectDto.setCategory(project.getCategory());
        log.info("<ProjectDto> constuctProjectDto({projectId = {}}) set category = {}", project.getProjectId(),
                projectDto.getCategory());

        projectDto.setQuestions(project.getQuestions());
        log.info("<ProjectDto> constuctProjectDto({projectId = {}}) set question[0].getQuestionId = {}", project.getProjectId(),
                projectDto.getQuestions().get(0).getQuestionId());

        // projectDto.setPayments(project.getPayments());

        // projectDto.setRewards(project.getRewards());

        return projectDto;
    }
}
