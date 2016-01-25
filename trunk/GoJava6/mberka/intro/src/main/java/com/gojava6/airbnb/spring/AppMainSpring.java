package com.gojava6.airbnb.spring;

import com.gojava6.airbnb.spring.modelSpring.User;
import com.gojava6.airbnb.spring.serviceSpring.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMainSpring {
    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring_config.xml");
        UserService userService = appContext.getBean("userService", UserService.class);

        User user = new User("John", "Lennon", "john@com.uk", "Liverpool");

        //userService.createUser(user);
        //userService.deleteUserById(8);
        userService.updateUserToHost(7);

    }
}
