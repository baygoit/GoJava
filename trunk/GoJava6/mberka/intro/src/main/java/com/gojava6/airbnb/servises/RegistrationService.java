package com.gojava6.airbnb.servises;

import com.gojava6.airbnb.dao.UserDAO;
import com.gojava6.airbnb.model.User;

public class RegistrationService {
    UserDAO userDAO = new UserDAO();

    public void registerUser(User user) {
        userDAO.addNewUser(user);
    }
}
