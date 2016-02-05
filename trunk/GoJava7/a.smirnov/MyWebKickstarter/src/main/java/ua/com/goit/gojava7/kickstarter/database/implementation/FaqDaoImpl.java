package ua.com.goit.gojava7.kickstarter.database.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.database.contract.FaqDao;

@Repository
public class FaqDaoImpl implements FaqDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Faq> getProjectFaqs(int projectId) {
		return entityManager.createNamedQuery("Faq.findProjectQuestions").setParameter("id", projectId).getResultList();
	}
	
	@Override
	@Transactional
	public void add(Faq faq) {
		entityManager.persist(faq);
	}

	@Override
	@Transactional
	public void remove(Faq faq) {
		entityManager.remove(faq);
	}
}
