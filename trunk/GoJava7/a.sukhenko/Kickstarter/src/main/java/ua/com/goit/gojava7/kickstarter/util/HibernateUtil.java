package ua.com.goit.gojava7.kickstarter.util;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{
    private static final Logger log = LogManager.getLogger(HibernateUtil.class);

    public static <T> List<T> listAndCast(Query query) {
        @SuppressWarnings("unchecked")
        List<T> list = query.list();
        return list;
    }
}
