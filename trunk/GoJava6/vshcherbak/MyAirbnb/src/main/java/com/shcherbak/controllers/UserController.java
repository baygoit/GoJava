package com.shcherbak.controllers;

import com.shcherbak.model.User;
import com.shcherbak.processing.UserJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
//@SessionAttributes({"userID", "type" })
public class UserController {
    //private int visitorCount = 0;
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    private UserJDBC userJDBC = (UserJDBC)context.getBean("userJDBC");

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String registerUser( @RequestParam("type") String type, @RequestParam("firstname") String firstname,
                            @RequestParam("lastname") String lastname, @RequestParam("email") String email,
                            @RequestParam("notify") String notify, @RequestParam("password") String password,
                            @RequestParam("login")String login, Model model) {
        String value = "\'" + login + "\'";
        List<User> users;
        users = userJDBC.getUsersByField("login", value);
        if (!users.isEmpty()) {
            model.addAttribute("message", "User with login " + login + " already exists" );
            return "user";
        }
        value = "\'" + email + "\'";
        users = userJDBC.getUsersByField("email", value);
        if (!users.isEmpty()) {
            model.addAttribute("message", "User with email " + email + " already exists" );
            return "user";
        }
        userJDBC.create(type.equals("host"), firstname, lastname,  email,
                notify.equals("yes"), new Date(), password, login);

        model.addAttribute("message", firstname);
        return "index";
    }

    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String login( @RequestParam("login") String login, @RequestParam("email") String email,
                         @RequestParam("password") String password, Model model) {
        String value = "";
        List<User> users;
        if (!login.isEmpty()) {
            //System.out.println("search by login");
            value = "\'" + login + "\'";
            users = userJDBC.getUsersByField("login", value);
            if (users.isEmpty()) {
                model.addAttribute("message", "User with login " + login + " not found");
                return "login";
            }
        } else if (!email.isEmpty()) {
            //System.out.println("search by email");
            value = "\'" + email + "\'";
            users = userJDBC.getUsersByField("email", value);
            if (users.isEmpty()) {
                model.addAttribute("message", "User with email " + email + " not found");
                return "login";
            }
        } else {
            model.addAttribute("message", "Reenter velues please");
            return "login";
        }

        User user = users.get(0);
        if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Password is not correct");
            return "login";
        }
        model.addAttribute("message", "Welcome," + user.getFirstname());
        model.addAttribute("userID", user.getUserID());
        model.addAttribute("type", user.getType());
        model.addAttribute("log", "in");
        return "index";
    }

}

