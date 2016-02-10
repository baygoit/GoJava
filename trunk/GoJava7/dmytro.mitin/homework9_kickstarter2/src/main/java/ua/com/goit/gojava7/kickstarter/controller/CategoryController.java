package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.goit.gojava7.kickstarter.domain.Category;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
public class CategoryController extends HttpServlet {

    @Autowired
    private MainController controller;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    protected String showCategory(Model model, @RequestParam int id) {
        List<Category> categories = controller.getCategories();
        Category category = categories.get(id);

        model.addAttribute("category", category);

        return "category";
    }
}
