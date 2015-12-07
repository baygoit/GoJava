package com.airbnb.Controllers;

import com.airbnb.model.User;
import com.airbnb.services.AdminService;
import com.airbnb.services.SpringException;
import com.airbnb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Игорь on 01.12.2015.
 */
@Controller
@SessionAttributes({ "name", "surname",
        "email", "password",
        "sign", "login",
        "unregistered", "admin_email",
        "admin_password" })
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/WEB-INF/planeview/login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignupPage() {
        return "/WEB-INF/planeview/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView();
        if (userService.isRegisterUser(email, password) == false) {
            try {
                User user = new User(name, surname, email, password);
                modelAndView.addObject("name", name);
                userService.registerUser(user);
                modelAndView.addObject("email", email);
                modelAndView.addObject("password", password);
                modelAndView.addObject("sign", "Sign out");
                modelAndView.addObject("login", "main");
                modelAndView.setViewName("/WEB-INF/planeview/thankyoupage");
            } catch (NullPointerException e) {
                modelAndView.addObject("error", "You've entered uncorrect data! Try again");
                modelAndView.setViewName("/WEB-INF/planeview/signup");
            }
        } else {
            modelAndView.addObject("uncorrectdata", "User with that email or password is registered! Try again");
            modelAndView.setViewName("/WEB-INF/planeview/signup");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("email") String email,
                                  @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView();
        if (userService.isRegisterUser(email, password)) {
            modelAndView.addObject("email", email);
            modelAndView.addObject("password", password);
            modelAndView.addObject("sign", "Sign out");
            modelAndView.addObject("login", "main");
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("unregistered", "Incorrect data! Please, try again or register");
            modelAndView.setViewName("/WEB-INF/planeview/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/adminpanel", method = RequestMethod.POST)
    public ModelAndView adminLogin(@RequestParam("admin_email") String email,
                                   @RequestParam("admin_password") String password) {

        ModelAndView modelAndView = new ModelAndView();
        if (adminService.isAdmin(email, password)) {
            modelAndView.addObject("admin_email", email);
            modelAndView.addObject("email", email);
            modelAndView.addObject("admin_password", password);
            modelAndView.addObject("password", password);
            modelAndView.addObject("sign", "Sign out");
            modelAndView.addObject("login", "main");
            modelAndView.addObject("users", userService.getAllUsers());
            modelAndView.setViewName("/WEB-INF/view/admin");
        } else {
            modelAndView.addObject("unregistered", "Incorrect data! Please, try again or register");
            modelAndView.setViewName("/WEB-INF/planeview/login");
        }
        return modelAndView;
    }
}

