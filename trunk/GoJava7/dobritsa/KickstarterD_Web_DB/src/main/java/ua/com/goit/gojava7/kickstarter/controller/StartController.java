package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.dao.*;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Reward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Transactional
@Controller
public class StartController{

    private static final Logger log = LoggerFactory.getLogger(StartController.class);

    @Autowired
    private QuoteDao quoteDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private Validator validator;

    @RequestMapping({"/index"})
    public ModelAndView start() {
        log.info("start()...");
        ModelAndView modelAndView = new ModelAndView("kickstarter");
        modelAndView.addObject("quote", quoteDao.getRandomQuote());
        modelAndView.addObject("categories", categoryDao.getAll());
        return modelAndView;
    }

    @RequestMapping("/category")
    public ModelAndView showCategory(@RequestParam(name = "id") Long categoryId) {
        log.info("showCategory()...");
        ModelAndView modelAndView = new ModelAndView("category");
        Category category = categoryDao.get(categoryId);

        // TODO
        if (category == null) {
            //404
        }

        modelAndView.addObject("projects", projectDao.getByCategory(categoryId));
        modelAndView.addObject("categoryName", category.getName());
        return modelAndView;
    }

    @RequestMapping("/project")
    public ModelAndView showProject(@RequestParam(name = "id") Long projectId) {
        log.info("showProject()...");
        ModelAndView modelAndView = new ModelAndView("project");
        Project project = projectDao.get(projectId);

        modelAndView.addObject("category", projectDao.getCategory(project));
        modelAndView.addObject("project", project);
        modelAndView.addObject("questions", projectDao.getQuestions(projectId));
        return modelAndView;
    }

    @RequestMapping("/reward")
    public ModelAndView showReward(@RequestParam(name = "projectId") Long projectId) {
        log.info("showReward()...");
        ModelAndView modelAndView = new ModelAndView("reward");
        Project project = projectDao.get(projectId);

        modelAndView.addObject("category", project.getCategory());
        modelAndView.addObject("project", project);
        modelAndView.addObject("rewards", rewardDao.getByProject(projectId));
        return modelAndView;
    }

    @RequestMapping("/question")
    public String  addQuestion(Model model, HttpServletRequest request) {
        log.info("addQuestion()...");
        Long projectId = Long.parseLong(request.getParameter("projectId"));
        String textQuestion = request.getParameter("question");

        questionDao.createQuestion(textQuestion, projectId);

        model.addAttribute("id", projectId);
        return "redirect:/project";
    }

    @RequestMapping("/payment")
    public ModelAndView showPayment(Model model, HttpServletRequest request) throws ServletException, IOException {

        model.addAttribute("request", request);

        if (rewardExists(request)) {
            return payWithReward(request);
        }

        return payWithoutReward(request);
    }

    @RequestMapping("/paymentCheck")
    public ModelAndView checkPayment(HttpServletRequest request) throws ServletException, IOException {

        Long projectId = Long.parseLong(request.getParameter("projectId"));
        Long amount = Long.parseLong(request.getParameter("amount"));
        String name = request.getParameter("name");
        String card = request.getParameter("card");

        Project project = projectDao.get(projectId);

        if (paymentDao.createPayment(name, card, amount, project)) {
            ModelAndView modelAndView = new ModelAndView("paymentOk");
            modelAndView.addObject("category", projectDao.getCategory(project));
            modelAndView.addObject("project", project);
            modelAndView.addObject("amount", amount);
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("payment");
        modelAndView.addObject("category", projectDao.getCategory(project));
        modelAndView.addObject("project", project);
        modelAndView.addObject("amount", amount);
        modelAndView.addObject("message", "-----Wrong data-----");
        return modelAndView;
    }

    private boolean rewardExists(HttpServletRequest request) {
        Long rewardId = Long.parseLong(request.getParameter("id"));
        return rewardId != 0;
    }

    private ModelAndView payWithReward(HttpServletRequest request) throws ServletException, IOException {
        Long rewardId = Long.parseLong(request.getParameter("id"));
        Reward reward = rewardDao.get(rewardId);
        Long amount = reward.getAmount();
        Project project = reward.getProject();
        Category category = project.getCategory();

        ModelAndView modelAndView = new ModelAndView("payment");

        modelAndView.addObject("category", category);
        modelAndView.addObject("project", project);
        modelAndView.addObject("amount", amount);

        return modelAndView;
    }


    private ModelAndView payWithoutReward(HttpServletRequest request) throws ServletException, IOException {
        Long projectId = Long.parseLong(request.getParameter("projectId"));
        Project project = projectDao.get(projectId);
        Category category = project.getCategory();

        if (amountIsValid(request)) {
            Long amount = Long.parseLong(request.getParameter("amount"));
            ModelAndView modelAndView = new ModelAndView("payment");
            modelAndView.addObject("category", category);
            modelAndView.addObject("project", project);
            modelAndView.addObject("amount", amount);
            return modelAndView;
        }

        List<Reward> rewards = rewardDao.getByProject(projectId);
        ModelAndView modelAndView = new ModelAndView("reward");
        modelAndView.addObject("rewards", rewards);
        modelAndView.addObject("category", category);
        modelAndView.addObject("project", project);
        modelAndView.addObject("message", "-----Wrong amount-----");
        return modelAndView;
    }

    private boolean amountIsValid(HttpServletRequest request) {
        return validator.validateAmountOfPledge(request.getParameter("amount"));
    }
}
