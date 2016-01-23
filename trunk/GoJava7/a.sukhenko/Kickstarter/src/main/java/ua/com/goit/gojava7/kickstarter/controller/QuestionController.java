package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuestionDatabaseDao;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.validator.QuestionValidator;

@Controller
public class QuestionController{
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private QuestionValidator validator;
    @Autowired
    private QuestionDatabaseDao questionDao;
    @Autowired
    private ProjectDao projectDao;
    

    
    @ModelAttribute("question")
    public Question createEmployeeModel() {
        // ModelAttribute value should be same as used in the questionAdd.jsp
        return new Question();
    }
    
    @RequestMapping(value = "/question/add", method = RequestMethod.GET)
    public ModelAndView  addQuestion(@RequestParam(name = "projectId") int projectId) {
        ModelAndView modelAndView = new ModelAndView("questionAdd");
        modelAndView.addObject("projectId",projectId);
        logger.info("Returning questionAdd.jsp page");
        return modelAndView;
    }
    
    @RequestMapping(value = "/question/add.do", method = RequestMethod.POST)
    public String saveQuestionAction(@RequestParam(name = "projectId") int projectId,
            @ModelAttribute("question") Question question,
            BindingResult bindingResult, Model model) {
        question.setProject(projectDao.getProject(projectId));
        validator.validate(question, bindingResult);
        if (bindingResult.hasErrors()) {
            logger.info("Returning empSave.jsp page");
            return "questionAdd";
        }
        logger.info("Returning questionAddSuccess.jsp page");
        model.addAttribute("question", question);
        questionDao.add(question);
        return "questionAddSuccess";
    }
    
    
    
}
