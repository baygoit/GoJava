package com.epic.app.service;

import com.epic.app.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Service
public interface UserService {
    public void add(User user);
    public void remove(User user);
    public User getUser(String login);
}
