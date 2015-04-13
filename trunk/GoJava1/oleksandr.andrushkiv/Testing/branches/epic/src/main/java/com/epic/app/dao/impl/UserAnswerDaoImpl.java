package com.epic.app.dao.impl;

import com.epic.app.dao.UserAnswerDao;
import com.epic.app.model.UserAnswer;
import org.springframework.stereotype.Repository;

/**
 * Created by Pas8sion on 17.01.2015.
 */
@Repository
public class UserAnswerDaoImpl extends AbstractHibernateDAO<UserAnswer> implements UserAnswerDao {
    public UserAnswerDaoImpl() {
        super(UserAnswer.class);
    }
}
