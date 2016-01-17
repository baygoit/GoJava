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
import ua.com.goit.gojava7.kickstarter.dto.RewardDto;
import ua.com.goit.gojava7.kickstarter.service.PaymentService;
import ua.com.goit.gojava7.kickstarter.service.ProjectService;
import ua.com.goit.gojava7.kickstarter.service.RewardService;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;
import ua.com.goit.gojava7.kickstarter.model.Project;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Transactional
@Controller
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private MyValidator myValidator;
    @Autowired
    private RewardService rewardService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private PaymentService paymentService;

    private ModelAndView modelAndView;

    @RequestMapping("/payment")
    public ModelAndView showPayment(@RequestParam Long rewardId, @RequestParam(required = false) Long projectId,
                                    @RequestParam(required = false) String amount) throws ServletException, IOException {
        log.info("showPayment(rewardId = {}, projectId = {}, amount = {})...", rewardId, projectId, amount);

        modelAndView = new ModelAndView();

        if (rewardExists(rewardId)) {
            return payWithReward(rewardId);
        }

        if(amountIsValid(amount)) {
            return payWithAmount(amount, projectId);
        }

        ProjectDto projectDto = projectService.getFullProject(projectId);
        modelAndView.addObject(projectDto);
        modelAndView.addObject("category", projectDto.getCategory());

        return returnWarning(projectId);
    }

    private boolean rewardExists(Long rewardId) {
        log.info("rewardExists()...");
        return rewardId != 0;
    }

    private ModelAndView payWithReward(Long rewardId) {
        log.info("payWithReward()...");

        RewardDto rewardDto = rewardService.get(rewardId);
        Long amount = rewardDto.getAmount();
        Project project = rewardDto.getProject();

        modelAndView.setViewName("payment");
        modelAndView.addObject("amount", amount);
        modelAndView.addObject("project", project);
        modelAndView.addObject("category", project.getCategory());
        return modelAndView;
    }

    private boolean amountIsValid(String amount) {
        log.info("amountIsValid()...");
        return myValidator.validateAmountOfPledge(amount);
    }

    public ModelAndView payWithAmount(String amount, Long projectId){
        log.info("payWithAmount()...");
        ProjectDto projectDto = projectService.getFullProject(projectId);
        modelAndView.setViewName("payment");
        modelAndView.addObject("project", projectDto);
        modelAndView.addObject("amount", Long.parseLong(amount));
        return modelAndView;
    }

    private ModelAndView returnWarning(Long projectId) {
        log.info("returnWarning()...");
        List<RewardDto> rewardsDto = rewardService.getByProject(projectId);

        modelAndView.setViewName("reward");
        modelAndView.addObject(rewardsDto);
        modelAndView.addObject("message", "-----Wrong amount-----");
        return modelAndView;
    }

    @RequestMapping(value = "/paymentCheck", method = RequestMethod.POST)
    public ModelAndView checkPayment(@RequestParam Long projectId, @RequestParam Long amount,
                                     @RequestParam String name, @RequestParam String card) throws ServletException, IOException {
        log.info("checkPayment(projectId = {}, amount = {}, name = {}, card = {})...", projectId, amount, name, card);

        ProjectDto projectDto = projectService.getFullProject(projectId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", projectDto.getCategory());
        modelAndView.addObject("project", projectDto);
        modelAndView.addObject("amount", amount);

        if (paymentService.createPayment(name, card, amount, projectId)) {
            modelAndView.setViewName("paymentOk");
            return modelAndView;
        }

        modelAndView.setViewName("payment");
        modelAndView.addObject("message", "-----Wrong data-----");
        return modelAndView;
    }
}
