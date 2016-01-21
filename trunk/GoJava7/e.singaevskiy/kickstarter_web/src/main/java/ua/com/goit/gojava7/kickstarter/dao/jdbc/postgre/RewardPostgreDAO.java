package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
public class RewardPostgreDAO implements RewardDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void clear() {
		entityManager.createNamedQuery("Reward.removeAll").executeUpdate();
	}

    @Override
    public Reward get(Long index) {
    	return entityManager.find(Reward.class, index);
    }

    @Override
    @Transactional
    public void add(Reward element) {
    	entityManager.persist(element);
    }

    @Override
    @Transactional
    public void addAll(List<Reward> elements) {
    	elements.forEach(entityManager::persist);
    }

    @Override
    public List<Reward> getAll() {
    	return entityManager.createNamedQuery("Reward.getAll", Reward.class).getResultList();
    }

    @Override
    public List<Reward> getByProject(Long projectId) {
    	TypedQuery<Reward> query = entityManager.createNamedQuery("Reward.getByProject", Reward.class);
		query.setParameter("project_id", projectId);
		return query.getResultList();
    }

}
