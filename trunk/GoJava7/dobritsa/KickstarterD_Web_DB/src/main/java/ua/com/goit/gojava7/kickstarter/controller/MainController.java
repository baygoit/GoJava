package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "indexLog";
    }
}
