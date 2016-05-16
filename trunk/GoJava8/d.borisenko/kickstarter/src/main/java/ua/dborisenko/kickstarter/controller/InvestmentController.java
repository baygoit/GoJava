package ua.dborisenko.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.dborisenko.kickstarter.dao.ProjectDao;
import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;

@Controller
public class InvestmentController {

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping(value = "/investment/{id}", method = RequestMethod.GET)
    public ModelAndView showProject(@PathVariable("id") Integer projectId) {
        ModelAndView mav = new ModelAndView("investment");
        try {
            Project project = projectDao.getWithRewards(projectId);
            mav.addObject("project", project);
            return mav;
        } catch (EmptyResultDataAccessException e) {
            mav.setViewName("error404");
            mav.addObject("errorText", ErrorText.PROJECT_NOT_FOUND);
            return mav;
        }
    }

    @RequestMapping(value = "/project/{id}/addInvestment", method = RequestMethod.POST)
    public ModelAndView addQuestion(@PathVariable("id") Integer projectId, @RequestParam("cardholder_name") String cardholderName,
            @RequestParam("card_number") String cardNumber, @RequestParam int amount, @RequestParam("custom_amount") int customAmount) {
        ModelAndView mav = new ModelAndView("redirect:/project/" + projectId);
        Project project = projectDao.get(projectId);
        Investment investment = new Investment();
        investment.setProject(project);
        investment.setCardHolderName(cardholderName);
        investment.setCardNumber(cardNumber);
        if (amount == 0) {
            investment.setAmount(customAmount);
        } else {
            investment.setAmount(amount);
        }
        if (investment.getAmount() <= 0) {
            mav.setViewName("error400");
            mav.addObject("errorText", ErrorText.NEGATIVE_AMOUNT);
        }
        projectDao.addInvestment(investment);
        return mav;
    }
}
