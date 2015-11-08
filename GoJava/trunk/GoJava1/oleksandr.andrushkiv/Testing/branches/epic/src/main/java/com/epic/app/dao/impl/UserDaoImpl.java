package com.epic.app.dao.impl;

import com.epic.app.dao.UserDao;
import com.epic.app.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Repository
public class UserDaoImpl extends AbstractHibernateDAO<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}
