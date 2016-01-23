package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDatabaseDao;
import ua.com.goit.gojava7.kickstarter.error.ResourceNotFoundException;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.validator.QuestionValidator;
@Controller
@Transactional
public class ProjectController{
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    
    @Autowired
    private ProjectDao  projectDao;
    @Autowired
    private QuestionDatabaseDao questionDao;
    
    //Artur Jpa new branch
    @RequestMapping("project")
    public ModelAndView project(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("project");
        logger.debug("action: project");
        Project project = null;
        try {
            project = projectDao.getProject(id);
        } catch (NoSuchElementException e) {
            logger.info("Didn't find project", e);
            throw new ResourceNotFoundException();
        }
        modelAndView.addObject("project", project);
        modelAndView.addObject("endtime", project.getProjectEndTime());
        modelAndView.addObject("paymentBonuses", project.getBonuses());
        List<Question> questions = questionDao.getQuestionsByProjectId(project.getId());
        modelAndView.addObject("questions", questions);
        Question question = new Question();
        modelAndView.addObject("question", question);
        return modelAndView;
    }
    
    
}
