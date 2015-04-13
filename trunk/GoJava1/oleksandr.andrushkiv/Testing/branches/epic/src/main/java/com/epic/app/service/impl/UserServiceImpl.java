package com.epic.app.service.impl;

import com.epic.app.dao.UserDao;
import com.epic.app.model.User;
import com.epic.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Transactional(readOnly = false)
    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void remove(User user) {
        userDao.remove(user.getId());
    }

    @Override
    public User getUser(String login) {
        return userDao.get("login",login);
    }
}
