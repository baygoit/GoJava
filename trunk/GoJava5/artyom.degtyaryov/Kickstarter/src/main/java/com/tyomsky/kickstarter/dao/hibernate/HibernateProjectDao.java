package com.tyomsky.kickstarter.dao.hibernate;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.dao.common.AbstractHibernateDao;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class HibernateProjectDao extends AbstractHibernateDao<Project> implements ProjectDAO {

    public HibernateProjectDao() {
        super(Project.class);
    }

    @Override
    public List<Project> getListByCategory(Category category) {
        List<Project> projects;
        projects = getList("category", category);
        return projects;
    }

}
