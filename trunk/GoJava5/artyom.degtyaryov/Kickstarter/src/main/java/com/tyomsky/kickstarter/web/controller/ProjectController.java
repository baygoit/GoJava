//package com.tyomsky.kickstarter.web.controller;
//
//import com.tyomsky.kickstarter.dao.CategoryDAO;
//import com.tyomsky.kickstarter.dao.ProjectDAO;
//import com.tyomsky.kickstarter.dao.QuestionAndAnswerDAO;
//import com.tyomsky.kickstarter.domain.Category;
//import com.tyomsky.kickstarter.domain.Project;
//import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class ProjectController {
//
//    @Autowired
//    ProjectDAO projectDAO;
//
//    @Autowired
//    CategoryDAO categoryDAO;
//
//    @Autowired
//    QuestionAndAnswerDAO questionAndAnswerDAO;
//
//    @RequestMapping(value = "/projects", method = RequestMethod.GET)
//    public String showProjectsByCategory(@RequestParam("categoryId") int categoryId, Model model) {
//        Category category = categoryDAO.get(categoryId);
//        List<Project> projects = projectDAO.getByCategoryId(categoryId);
//        model.addAttribute("category", category);
//        model.addAttribute("projects", projects);
//        return "projects";
//    }
//
//    @RequestMapping(value = "/project", method = RequestMethod.GET)
//    public String showProject(@RequestParam("projectId") int projectId, Model model) {
//        Project project = projectDAO.get(projectId);
//        List<QuestionAndAnswer> questionsAndAnswers = questionAndAnswerDAO.getByProjectId(projectId);
//        System.out.println(questionsAndAnswers.size());
//        model.addAttribute("project", project);
//        model.addAttribute("questionsAndAnswers", questionsAndAnswers);
//        return "project";
//    }
//
//    @RequestMapping(value = "/project/question", method = RequestMethod.POST)
//    public String handleQuestion(@RequestParam("question") String question, @RequestParam("projectId") int projectId) {
//        questionAndAnswerDAO.addQuestion(projectId, question);
//        return "redirect:/project?projectId="+projectId;
//    }
//
//}
