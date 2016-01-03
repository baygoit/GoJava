package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.hibernate.HibernateUtil;

@Repository
public class FaqDaoMysqlImpl implements FaqDao {

	public void add(Faq faq) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(faq);
		transaction.commit();
		session.close();
	}

	public void remove(Faq faq) {
		// TODO
	}

	@SuppressWarnings("unchecked")
	public List<Faq> getProjectFaqs(int projectId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Faq.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		List<Faq> faqs = criteria.list();

		session.close();
		return faqs;
	}
}
