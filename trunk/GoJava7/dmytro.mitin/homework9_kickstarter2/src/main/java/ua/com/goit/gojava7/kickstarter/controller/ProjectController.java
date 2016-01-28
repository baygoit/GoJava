package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private MainController controller;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String showProject(Model model, @RequestParam int id, @RequestParam int categoryId) {
        List<Category> categories = controller.getCategories();
        Category category = categories.get(categoryId);
        Project project = category.getProjects().get(id);

        model.addAttribute("project", project);
        model.addAttribute("category", category);

        return "project";
    }

    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String handleQuestion(Model model, @RequestParam String question,
                                 @RequestParam int id, @RequestParam int categoryId)
    {
        List<Category> categories = controller.getCategories();
        Category category = categories.get(categoryId);
        Project project = category.getProjects().get(id);

        if (question != null && question.length() > 0) {
            controller.askQuestion(project, question);
        }

        model.addAttribute("project", project);
        model.addAttribute("category", category);

        return "project";
    }

    @RequestMapping(value = "/donate", method = RequestMethod.POST)
    public String doDonate(Model model, @RequestParam String sum,
                           @RequestParam int id, @RequestParam int categoryId)
    {
        List<Category> categories = controller.getCategories();
        Category category = categories.get(categoryId);
        Project project = category.getProjects().get(id);

        if (sum != null && !sum.equals("other")) {
            controller.donate(project, Integer.parseInt(sum));
        }

        model.addAttribute("project", project);
        model.addAttribute("category", category);

        return "project";
    }
}
