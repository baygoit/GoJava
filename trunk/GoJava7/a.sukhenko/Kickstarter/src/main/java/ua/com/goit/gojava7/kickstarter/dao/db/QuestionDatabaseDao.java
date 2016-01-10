package ua.com.goit.gojava7.kickstarter.dao.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class QuestionDatabaseDao{

    private static final Logger logger = LogManager.getLogger(QuestionDatabaseDao.class);
    @Autowired
    private SessionFactory      sessionFactory;

}
