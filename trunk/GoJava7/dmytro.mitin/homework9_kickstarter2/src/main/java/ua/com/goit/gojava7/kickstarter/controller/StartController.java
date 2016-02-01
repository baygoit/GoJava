package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

import java.util.List;

@Controller
public class StartController {

    @Autowired
    private MainController controller;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doStart(Model model) {
        Quote quote = controller.getRandomQuote();
        List<Category> categories =  controller.getCategories();

        model.addAttribute("quote", quote);
        model.addAttribute("categories", categories);

        return "start";
    }
}
