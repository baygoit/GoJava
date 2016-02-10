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

import javax.servlet.ServletException;
import java.io.IOException;

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

    @RequestMapping("/payment")
    public ModelAndView showPayment(@RequestParam Long rewardId, @RequestParam(required = false) Long projectId,
                                    @RequestParam(required = false) String amount) throws ServletException, IOException {
        log.info("showPayment(rewardId = {}, projectId = {}, amount = {})...", rewardId, projectId, amount);

        if (rewardExists(rewardId)) {
            return payWithReward(rewardId);
        }

        if(amountIsValid(amount)) {
            return payWithAmount(amount, projectId);
        }

        return returnWarning(projectId);
    }

    protected boolean rewardExists(Long rewardId) {
        log.info("rewardExists(rewardId = {})...", rewardId);

        return rewardId != 0;
    }

    protected ModelAndView payWithReward(Long rewardId) {
        log.info("payWithReward(rewardId = {})...", rewardId);

        RewardDto rewardDto = rewardService.get(rewardId);
        ProjectDto projectDto = rewardDto.getProjectDto();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payment");
        modelAndView.addObject("amount", rewardDto.getAmount());
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);

        log.info("payWithReward(rewardId = {}) returned {} ", rewardId, modelAndView);
        return modelAndView;
    }

    protected boolean amountIsValid(String amount) {
        log.info("amountIsValid(amount = {})...", amount);
        return myValidator.validateAmountOfPledge(amount);
    }

    public ModelAndView payWithAmount(String amount, Long projectId){
        log.info("payWithAmount(amount = {}, projectId = {})...", amount, projectId);

        ProjectDto projectDto = projectService.getProjectIdNameCategory(projectId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payment");
        modelAndView.addObject("amount", Long.parseLong(amount));
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);

        log.info("payWithAmount(amount = {}, projectId = {}) returned {} ", amount, projectId, modelAndView);
        return modelAndView;
    }

    public ModelAndView returnWarning(Long projectId) {
        log.info("returnWarning(projectId = {})...", projectId);

        ProjectDto projectDto = projectService.getProjectIdNameCategoryRewards(projectId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reward");
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);
        modelAndView.addObject("rewards", projectDto.getRewards());
        modelAndView.addObject("message", "-----Wrong amount-----");

        log.info("returnWarning(projectId = {}) returned {} ", projectId, modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/paymentCheck", method = RequestMethod.POST)
    public ModelAndView checkPayment(@RequestParam Long projectId, @RequestParam Long amount,
                                     @RequestParam String name, @RequestParam String card) throws ServletException, IOException {
        log.info("checkPayment(projectId = {}, amount = {}, name = {}, card = {})...", projectId, amount, name, card);

        ProjectDto projectDto = projectService.getProjectIdNameCategory(projectId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("amount", amount);
        modelAndView.addObject("category", projectDto.getCategoryDto());
        modelAndView.addObject("project", projectDto);

        if (paymentService.createPayment(name, card, amount, projectId)) {
            modelAndView.setViewName("paymentOk");
            log.info("checkPayment(projectId = {}, amount = {}, name = {}, card = {}) returned {}", projectId, amount, name, card, modelAndView);
            return modelAndView;
        }

        modelAndView.setViewName("payment");
        modelAndView.addObject("message", "-----Wrong data-----");

        log.info("checkPayment(projectId = {}, amount = {}, name = {}, card = {}) returned {}", projectId, amount, name, card, modelAndView);
        return modelAndView;
    }
}
