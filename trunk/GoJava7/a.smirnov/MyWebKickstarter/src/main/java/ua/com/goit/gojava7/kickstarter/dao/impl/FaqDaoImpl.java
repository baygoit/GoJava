package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;

@Repository
public class FaqDaoImpl implements FaqDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void add(Faq faq) {
		Session session = sessionFactory.getCurrentSession();
		session.save(faq);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Faq> getProjectFaqs(int projectId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Faq.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		List<Faq> faqs = criteria.list();

		return faqs;
	}

	public void remove(Faq faq) {
		// TODO
	}
}
