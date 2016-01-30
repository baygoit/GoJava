package ua.com.goit.gojava7.kickstarter.controller;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

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
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;
@Controller
@Transactional
public class ProjectController{
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private static final String MINUTES_LEFT = " minutes to go";
    private static final String HOURS_LEFT = " hours to go";
    private static final String DAYS_LEFT = " days to go";
    private static final String SECONDS_LEFT = " seconds to go";

    @Autowired
    private ProjectDao  projectDao;
    @Autowired
    private QuestionDatabaseDao questionDao;
    
    
    @RequestMapping("project")
    public ModelAndView project(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("project");
        logger.debug("action: project");
        Project project = projectDao.getProject(id);

        if(!Optional.of(project).isPresent()){
            return new ModelAndView("projects");
        }
        modelAndView.addObject("project", project);
        modelAndView.addObject("endtime", getProjectEndTime(project));
        modelAndView.addObject("paymentBonuses", project.getBonuses());
        List<Question> questions = questionDao.getQuestionsByProjectId(project.getId());
        modelAndView.addObject("questions", questions);
        Question question = new Question();
        modelAndView.addObject("question", question);
        return modelAndView;
    }

    public String getProjectEndTime(Project project) {
        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = project.getEnddate().atZone(zoneId).toEpochSecond();
        long time = epoch - System.currentTimeMillis() / 1000;
        String msg = +time + SECONDS_LEFT;
        if (time >= 86400) {
            msg = (time / 86400) + DAYS_LEFT;
        } else if ((time >= 3600) && ((time % 3600) == 0)) {
            msg = (time / 60 / 60) + HOURS_LEFT;

        } else if (time >= 60) {
            msg = (time / 60) + MINUTES_LEFT;
        }
        return msg;
    }
    

}
