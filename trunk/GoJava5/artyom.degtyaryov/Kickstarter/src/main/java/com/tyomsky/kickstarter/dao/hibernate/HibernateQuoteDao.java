package com.tyomsky.kickstarter.dao.hibernate;

import com.tyomsky.kickstarter.dao.QuoteDAO;
import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.Quote;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HibernateQuoteDao extends AbstractHibernateDao <Quote> implements QuoteDAO{

    public HibernateQuoteDao() {
        super(Quote.class);
    }

}
