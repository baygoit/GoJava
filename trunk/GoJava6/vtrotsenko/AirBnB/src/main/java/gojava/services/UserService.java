package gojava.services;

import gojava.dao.UserDAO;
import gojava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by root on 04.11.15.
 */
@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User registerUser(User user) {
        userDAO.create(user);
        return user;
    }

    public User loginUser(String email, String password) {
        List<User> users = userDAO.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

}
