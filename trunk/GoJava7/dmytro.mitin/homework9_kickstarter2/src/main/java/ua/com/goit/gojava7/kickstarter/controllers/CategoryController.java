package ua.com.goit.gojava7.kickstarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.goit.gojava7.kickstarter.model.Category;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoryController extends HttpServlet {

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    protected String showCategory(Model model, @RequestParam int id, HttpSession session) {
        List<Category> categories = (List<Category>) session.getAttribute("categories");
        Category category = categories.get(id);
        model.addAttribute("category", category);
        model.addAttribute("categoryId", id);

        return "category";
    }
}
