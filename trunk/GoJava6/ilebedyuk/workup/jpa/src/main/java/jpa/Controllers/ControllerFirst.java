package jpa.Controllers;


/**
 * Created by Игорь on 02.12.2015.
 */
import jpa.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerFirst {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    Dao dao = context.getBean("Dao", Dao.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView getPage(HttpServletRequest request) {
        request.setAttribute("users", dao.getAllUsers());//to do modelAndView
        return new ModelAndView("index");
    }
}
