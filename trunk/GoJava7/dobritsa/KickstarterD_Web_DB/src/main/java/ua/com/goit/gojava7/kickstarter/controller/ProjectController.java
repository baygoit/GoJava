package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dto.ProjectDto;
import ua.com.goit.gojava7.kickstarter.service.ProjectService;
import ua.com.goit.gojava7.kickstarter.service.QuestionService;

@Transactional
@Controller
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/project")//()
    public ModelAndView showProject(@RequestParam Long projectId) {
        log.info("showProject(projectId = {})...", projectId);

        ProjectDto projectDto = projectService.getFullProjectDto(projectId);

        ModelAndView modelAndView = new ModelAndView("project");
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);
        modelAndView.addObject("questions", projectDto.getQuestions());

        log.info("showProject(projectId = {}) returned {} ", projectId, modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public ModelAndView  addQuestion(@RequestParam Long projectId, @RequestParam(name = "question") String textQuestion) {
        log.info("question(projectId = {}, question = {})...", projectId, textQuestion);

        questionService.createQuestion(textQuestion, projectId);

        ModelAndView modelAndView = new ModelAndView("redirect:/project");
        modelAndView.addObject("projectId", projectId);

        log.info("addQuestion(projectId = {}, question = {}) returned {}", projectId, textQuestion, modelAndView);
        return modelAndView;
    }

    @RequestMapping("/reward")
    public ModelAndView showReward(@RequestParam Long projectId) {
        log.info("showReward(projectId = {})...", projectId);

        ProjectDto projectDto = projectService.getProjectIdNameCategoryRewards(projectId);

        ModelAndView modelAndView = new ModelAndView("reward");
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);
        modelAndView.addObject("rewards", projectDto.getRewards());

        log.info("showReward(projectId = {}) returned {} ", projectId, modelAndView);
        return modelAndView;
    }
}
