package ua.dborisenko.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;
import ua.dborisenko.kickstarter.validator.QuestionValidator;

@Controller
public class QuestionController {

    @Autowired
    private ProjectDao projectDao;

    private ModelAndView getQuestionModelAndView(int projectId) {
        ModelAndView modelAndView = new ModelAndView("question");
        try {
            Project project = projectDao.getWithQuestions(projectId);
            modelAndView.addObject(project);
        } catch (EmptyResultDataAccessException e) {
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.projectNotFound");
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(value = "/question/{projectId}", method = RequestMethod.GET)
    public ModelAndView showQuestionForm(@PathVariable Integer projectId,
            @ModelAttribute("question") Question question) {
        ModelAndView modelAndView = getQuestionModelAndView(projectId);
        modelAndView.addObject(new Question());
        return modelAndView;
    }

    @RequestMapping(value = "/question/{projectId}", method = RequestMethod.POST)
    public ModelAndView addQuestion(@PathVariable Integer projectId, @ModelAttribute("question") Question question,
            BindingResult errors) {
        QuestionValidator questionValidator = new QuestionValidator();
        questionValidator.validate(question, errors);
        if (errors.hasErrors()) {
            return getQuestionModelAndView(projectId);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectId);
        try {
            Project project = projectDao.get(projectId);
            question.setProject(project);
        } catch (EmptyResultDataAccessException e) {
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.projectNotFound");
            return modelAndView;
        }
        projectDao.addQuestion(question);
        return modelAndView;
    }
}
