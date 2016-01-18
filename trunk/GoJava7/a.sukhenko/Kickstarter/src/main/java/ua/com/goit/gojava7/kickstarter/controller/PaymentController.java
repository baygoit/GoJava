package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.util.QuestionValidator;
import ua.com.goit.gojava7.kickstarter.util.Validator;

@Transactional
@Controller
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private Validator myValidator;
  

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ModelAndView showPayment(@RequestParam int rewardId, @RequestParam(required = false) int projectId,
                                    @RequestParam(required = false) String amount) throws ServletException, IOException {
        log.info("showPayment()...");
        Project project = projectDao.getProject(projectId);
        
        if(myValidator.validateAmountOfPledge(amount)){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("payment");
            modelAndView.addObject(amount);
            modelAndView.addObject(project);
              return modelAndView;
        }
        else{
            log.info("returnWarning()...");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("paymentBonuses", project.getBonuses());
            modelAndView.setViewName("reward");
            modelAndView.addObject(project);
            modelAndView.addObject("message", "-----Wrong amount-----");
            return modelAndView;
        }
       
    }
    
  
    
}
