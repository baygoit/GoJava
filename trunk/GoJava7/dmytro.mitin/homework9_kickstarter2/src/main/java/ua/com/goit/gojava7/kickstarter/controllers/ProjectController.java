package ua.com.goit.gojava7.kickstarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.goit.gojava7.kickstarter.controller.MainController;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProjectController {

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String showProject(Model model, @RequestParam int id, @RequestParam int categoryId, HttpSession session) {
        List<Category> categories = (List<Category>) session.getAttribute("categories");
        Category category = categories.get(categoryId);
        Project project = category.getProjects().get(id);
        model.addAttribute("project", project);
        model.addAttribute("category", category);
        model.addAttribute("categoryId", categoryId);

        return "project";

    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String handleQuestion(Model model, @RequestParam String question, HttpSession session) {
        Project project = (Project) session.getAttribute("project");
        Category category = (Category) session.getAttribute("category");
        int categoryId = (Integer) session.getAttribute("categoryId");
        session.removeAttribute("project");
        session.removeAttribute("category");
        session.removeAttribute("categoryId");
        MainController controller = (MainController) session.getAttribute("controller");
        if (question != null && question.length() > 0) {
            controller.askQuestion(project, question);
        }

        model.addAttribute("project", project);
        model.addAttribute("category", category);
        model.addAttribute("categoryId", categoryId);

        return "project";
    }

    @RequestMapping(value = "/donate", method = RequestMethod.POST)
    public String doDonate(Model model, @RequestParam String sum, HttpSession session) {
        Project project = (Project) session.getAttribute("project");
        Category category = (Category) session.getAttribute("category");
        int categoryId = (Integer) session.getAttribute("categoryId");
        session.removeAttribute("project");
        session.removeAttribute("category");
        session.removeAttribute("categoryId");
        model.addAttribute("project", project);
        model.addAttribute("category", category);
        model.addAttribute("categoryId", categoryId);

        if (sum != null && !sum.equals("other")) {
            MainController controller = (MainController) session.getAttribute("controller");
            controller.donate(project, Integer.parseInt(sum));
        }

        return "project";
    }
}
