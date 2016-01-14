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
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.Project;

@Transactional
@Controller
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public ModelAndView showProject(@RequestParam Long projectId) {
        log.info("showProject()...");

        Project project = projectDao.get(projectId);

        ModelAndView modelAndView = new ModelAndView("project");
        modelAndView.addObject("category", projectDao.getCategory(project));
        modelAndView.addObject("project", project);
        modelAndView.addObject("questions", projectDao.getQuestions(projectId));
        return modelAndView;
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String  addQuestion(@RequestParam Long projectId, @RequestParam(name = "question") String textQuestion) {
        log.info("question()...");

        questionDao.createQuestion(textQuestion, projectId);

        return "redirect:/project?projectId=" + projectId;
    }
}
