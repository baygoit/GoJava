package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;
import com.donishchenko.airbnb.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private UserService userService;

    @RequestMapping()
    public String getProfile() {
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editProfile(@RequestParam String email,
                              @RequestParam String name,
                              @RequestParam String surname,
                              HttpServletRequest request, Model model) {

        UserValidator userValidator = new UserValidator();
        userValidator.validateEmail(email);
        userValidator.validateName(name);
        userValidator.validateSurname(surname);

        if (userValidator.hasErrors()) {
            Map<String, String> errors = userValidator.getErrors();
            for (Map.Entry<String, String> error : errors.entrySet()) {
                model.addAttribute(error.getKey(), error.getValue());
            }
        } else {
            HttpSession session = request.getSession();

            //TODO maybe save old values if fail update
            User user = (User) session.getAttribute("user");
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);

            userService.updateUser(user);

            model.addAttribute("updateMessage", "Successfully");

        }

        return "profile";
    }
}
