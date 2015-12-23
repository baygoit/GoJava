package com.gojava6.servises;

import com.gojava6.dao.UserDAO;
import com.gojava6.model.User;

public class RegistrationService {
    UserDAO userDAO = new UserDAO();

    public void registerUser(User user) {
        userDAO.addNewUser(user);
    }
}
