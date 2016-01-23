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
    @Autowired
    private CategoryService categoryService;

    public ProjectDto getProjectIdNameCategoryRewards(Long projectId) {
        log.info("<ProjectDto> getProjectForReward(projectId = {})...", projectId);

        Project project = projectDao.get(projectId);
        //TODO if(project!=null)

        return constuctProjectDtoIdNameCategoryRewards(project);
    }

    private ProjectDto constuctProjectDtoIdNameCategoryRewards(Project project) {
        log.info("<ProjectDto> constuctShortProjectDto(projectId = {})...", project.getProjectId());

        ProjectDto projectDto =  constructProjectDtoIdNameCategory(project);
        projectDto.setRewards(project.getRewards());

        return projectDto;
    }

    public ProjectDto getProjectIdNameCategory(Long projectId) {
        log.info("<ProjectDto> getProjectIdNameCategory(projectId = {})...", projectId);

        Project project = projectDao.get(projectId);
        //TODO if(project!=null)

        return constructProjectDtoIdNameCategory(project);
    }

    protected ProjectDto constructProjectDtoIdNameCategory(Project project) {
        log.info("<ProjectDto> constuctShortProjectDto(projectId = {})...", project.getProjectId());

        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(project.getProjectId());
        projectDto.setName(project.getName());
        projectDto.setCategoryDto(categoryService.constuctShortCategoryDto(project.getCategory()));

        return projectDto;
    }

    public ProjectDto getFullProject(Long projectId) {
        log.info("<ProjectDto> getFullProject(projectId = {})...", projectId);

        Project project = projectDao.get(projectId);
        log.info("<ProjectDto> getFullProject(projectId = {}) get {}", projectId, project);

        return constuctFullProjectDto(project);
    }

    private ProjectDto constuctFullProjectDto(Project project) {
        log.info("<ProjectDto> constuctFullProjectDto(projectId = {})...", project.getProjectId());

        ProjectDto projectDto = constuctShortProjectDto(project);

        projectDto.setHistory(project.getHistory());
        projectDto.setLink(project.getLink());

        projectDto.setCategory(project.getCategory());
        log.info("<ProjectDto> constuctFullProjectDto(projectId = {}) set category = {}", project.getProjectId(),
                projectDto.getCategory());

        projectDto.setQuestions(project.getQuestions());
        log.info("<ProjectDto> constuctFullProjectDto(projectId = {}) set {} questions", project.getProjectId(),
                projectDto.getQuestions().size());

        log.info("<ProjectDto> constuctFullProjectDto(projectId = {}) returned {}", project.getProjectId(),
                projectDto);
        return projectDto;
    }

    protected List<ProjectDto> constuctShortProjectDto(List<Project> projects) {
        List<ProjectDto> projectsDto = new ArrayList<>();

        for(Project project : projects)
            projectsDto.add(constuctShortProjectDto(project));

        return projectsDto;
    }

    private ProjectDto constuctShortProjectDto(Project project) {
        log.info("<ProjectDto> constuctShortProjectDto(projectId = {})...", project.getProjectId());

        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(project.getProjectId());
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setGoal(project.getGoal());
        projectDto.setDaysToGo(project.getDaysToGo());

        projectDto.setPledged(paymentDao.calculatePledgedForProject(project.getProjectId()));
        log.info("<ProjectDto> constuctShortProjectDto(projectId = {}) set pledged = {}", project.getProjectId(),
                projectDto.getPledged());

        log.info("<ProjectDto> constuctShortProjectDto(projectId = {}) returned {}", project.getProjectId(),
                projectDto);
        return projectDto;
    }
}
