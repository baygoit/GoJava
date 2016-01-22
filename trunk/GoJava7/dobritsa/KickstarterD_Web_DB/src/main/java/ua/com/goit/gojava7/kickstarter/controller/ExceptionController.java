package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController {

    @RequestMapping("/error/404.html")
    public ModelAndView get404() {

        ModelAndView modelAndView = new ModelAndView("404");
        return modelAndView;
    }

    @RequestMapping("/error/500.html")
    public ModelAndView get500(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("500");
        modelAndView.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
        modelAndView.addObject("reason", request.getAttribute("javax.servlet.error.message"));
        return modelAndView;
    }
}
