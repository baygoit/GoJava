package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
import com.tyomsky.kickstarter.service.ProjectService;
import com.tyomsky.kickstarter.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "**/project")
public class ProjectController {

    ProjectService projectService;
    QuestionAndAnswerService questionAndAnswerService;

    @RequestMapping(value = "{projectId}", method = RequestMethod.GET)
    public String showProject(@PathVariable("projectId") int projectId, Model model) {
        Project project = projectService.getProjectById(projectId);
        List<QuestionAndAnswer> questionsAndAnswers = questionAndAnswerService.getListByProject(project);
        model.addAttribute("project", project);
        model.addAttribute("questionsAndAnswers", questionsAndAnswers);
        return "project";
    }

    @RequestMapping(value = "question", method = RequestMethod.POST)
    public String handleQuestion(@RequestParam("question") String question, @RequestParam("projectId") int projectId) {
        questionAndAnswerService.save(new QuestionAndAnswer(question));
        return "redirect:/project/"+projectId+"/";
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setQuestionAndAnswerService(QuestionAndAnswerService questionAndAnswerService) {
        this.questionAndAnswerService = questionAndAnswerService;
    }
}
