package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.model.Project;

@Transactional
@Controller//project/rewards
public class RewardsController {

    private static final Logger log = LoggerFactory.getLogger(RewardsController.class);

    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private ProjectDao projectDao;

    @RequestMapping("/reward")
    public ModelAndView showReward(@RequestParam Long projectId) {
        log.info("showReward({})...", projectId);

        Project project = projectDao.get(projectId);

        ModelAndView modelAndView = new ModelAndView("reward");
        modelAndView.addObject("category", project.getCategory());
        modelAndView.addObject("project", project);
        modelAndView.addObject("rewards", rewardDao.getByProject(projectId));
        return modelAndView;
    }
}
