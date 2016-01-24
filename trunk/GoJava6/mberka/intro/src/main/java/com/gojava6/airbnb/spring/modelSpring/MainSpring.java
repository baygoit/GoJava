package com.gojava6.airbnb.spring.modelSpring;

import com.gojava6.airbnb.spring.daoSpring.UserDAO;
import com.gojava6.airbnb.spring.daoSpring.UserDAOHibernateSpring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring_config.xml");
        UserDAO userDAO = appContext.getBean("userDAO", UserDAO.class);

        System.out.println(userDAO.getAllUsers());
        System.out.println(userDAO.getAllUsers().size());

        User user = userDAO.findUserById(1);
        System.out.println(user);

        String userName = userDAO.findUserNameById(2);
        System.out.println(userName);

        //userDAO.deleteUserById(4);

        User user2 = new User("Lisa", "Simpson", "Lisa@org.usa", "SanFrancisco");
        //userDAO.addNewUser(user2);

        System.out.println(userDAO.getAllUsers());

        UserDAOHibernateSpring userDAOHibernateSpring =
                appContext.getBean("userDAOHibernateSpring", UserDAOHibernateSpring.class);

        System.out.println(userDAOHibernateSpring.findUserNameById(3));

        System.out.println(userDAOHibernateSpring.findUserIdByEmail("Lisa@org.usa"));




    }

}
