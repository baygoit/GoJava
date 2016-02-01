package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.db.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.validator.PaymentValidator;

@Transactional
@Controller
@RequestMapping(value = "/payment", method = RequestMethod.GET)
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private PaymentValidator validator;

    @ModelAttribute("payment")
    public Payment createPaymentModel() {
        return new Payment();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPayment(@RequestParam Integer projectId) {
        ModelAndView modelAndView = new ModelAndView("paymentAdd");
        modelAndView.addObject("projectId", projectId);
        log.info("Returning projectAdd.jsp page");
        return modelAndView;
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String savePaymentAction(@RequestParam Integer projectId, @RequestParam Long amount, @ModelAttribute("payment") Payment payment, BindingResult bindingResult, Model model) {
        payment.setProject(projectDao.getProject(projectId));
        validator.validate(payment, bindingResult);
        if (bindingResult.hasErrors() || !projectExists(projectId)){
            log.info("Returning paymentAdd.jsp page");
            return "paymentAdd";
        }
        log.info("Returning paymentAddSuccess.jsp page");
        model.addAttribute(payment);
        paymentDao.add(payment);
        return "paymentAddSuccess";
    }


    private boolean projectExists(Integer projectId){
        return (projectDao.getProject(projectId) != null);
    }

}
