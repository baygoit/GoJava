package com.gojava6.airbnb.spring.serviceSpring;

import com.gojava6.airbnb.spring.daoSpring.UserDAO;
import com.gojava6.airbnb.spring.modelSpring.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void createUser(User user) {
        userDAO.addNewUser(user);
    }

    public void deleteUserById(int idUser) {
        userDAO.deleteUserById(idUser);
    }

    public void updateUserToHost(int idUser) {
        userDAO.updateUserToHost(idUser);
    }

}
