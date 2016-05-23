package ua.dborisenko.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.validator.InvestmentValidator;

@Controller
public class InvestmentController {

    @Autowired
    private ProjectDao projectDao;
    
    private static final Logger log = LoggerFactory.getLogger(InvestmentController.class);

    private ModelAndView getInvestmentModelAndView(int projectId) {
        ModelAndView modelAndView = new ModelAndView("investment");
        try {
            Project project = projectDao.getWithRewards(projectId);
            modelAndView.addObject(project);
            return modelAndView;
        } catch (EmptyResultDataAccessException e) {
            log.warn("Could not found project with id {}", projectId);
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.projectNotFound");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/investment/{projectId}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable Integer projectId,
            @ModelAttribute("investment") Investment investment) {
        ModelAndView modelAndView = getInvestmentModelAndView(projectId);
        modelAndView.addObject(new Investment());
        return modelAndView;
    }

    @RequestMapping(value = "/investment/{projectId}", method = RequestMethod.POST)
    public ModelAndView addQuestion(@PathVariable Integer projectId,
            @ModelAttribute("investment") Investment investment, BindingResult errors) {
        InvestmentValidator investmentValidator = new InvestmentValidator();
        investmentValidator.validate(investment, errors);
        if (errors.hasErrors()) {
            return getInvestmentModelAndView(projectId);
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/project/" + projectId);
        try {
            Project project = projectDao.get(projectId);
            investment.setProject(project);
        } catch (EmptyResultDataAccessException e) {
            log.warn("Could not found project with id {}", projectId);
            modelAndView.setViewName("error404");
            modelAndView.addObject("errorText", "error.projectNotFound");
            return modelAndView;
        }
        projectDao.addInvestment(investment);
        log.info("New investment with id {} created for project {}", investment.getId(), projectId);
        return modelAndView;
    }
}
