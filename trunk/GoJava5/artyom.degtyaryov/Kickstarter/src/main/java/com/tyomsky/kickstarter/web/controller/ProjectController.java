package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
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

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    QuestionAndAnswerDAO questionAndAnswerDAO;

    @RequestMapping(value = "{projectId}", method = RequestMethod.GET)
    public String showProject(@PathVariable("projectId") int projectId, Model model) {
        Project project = projectDAO.get(projectId);
        List<QuestionAndAnswer> questionsAndAnswers = questionAndAnswerDAO.getList("project.id", projectId);
        System.out.println(questionsAndAnswers.size());
        model.addAttribute("project", project);
        model.addAttribute("questionsAndAnswers", questionsAndAnswers);
        return "project";
    }

    @RequestMapping(value = "question", method = RequestMethod.POST)
    public String handleQuestion(@RequestParam("question") String question, @RequestParam("projectId") int projectId) {
        questionAndAnswerDAO.save(new QuestionAndAnswer(question));
        return "redirect:/project/"+projectId+"/";
    }

}
