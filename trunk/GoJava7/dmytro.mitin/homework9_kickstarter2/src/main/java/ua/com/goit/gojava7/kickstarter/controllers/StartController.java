package ua.com.goit.gojava7.kickstarter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.goit.gojava7.kickstarter.controller.MainController;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StartController {

    private MainController controller;

    @Autowired
    public StartController(MainController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String doStart(Model model, HttpSession session) {
        Quote quote = controller.getRandomQuote();
        List<Category> categories =  controller.getCategories();

        model.addAttribute("quote", quote);
        session.setAttribute("categories", categories);
        session.setAttribute("controller", controller);
//        ServletContext application = request.getServletContext();
//        application.setAttribute("categories", categories);
//        application.setAttribute("controller", controller);

        return "start";
    }
}
