package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;
import com.donishchenko.airbnb.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String tryLogin(@RequestParam String login,
                           @RequestParam String password,
                           HttpServletRequest request, Model model) {

        if (login.isEmpty() || password.isEmpty()) {
            model.addAttribute("loginError", "Empty login or password");

            return "login";
        }

        User user = userService.login(login, password);
        if (user == null) {
            model.addAttribute("loginError", "Invalid login or password");

            return "login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, HttpServletRequest request, Model model) {
        UserValidator userValidator = new UserValidator();

        userValidator.validate(user);

        if (userValidator.hasErrors()) {
            Map<String, String> errors = userValidator.getErrors();
            for (Map.Entry<String, String> error : errors.entrySet()) {
                model.addAttribute(error.getKey(), error.getValue());
            }

            model.addAttribute("user", user);

            return "registration";
        } else {
            userService.register(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            return "redirect:/";
        }
    }
}
