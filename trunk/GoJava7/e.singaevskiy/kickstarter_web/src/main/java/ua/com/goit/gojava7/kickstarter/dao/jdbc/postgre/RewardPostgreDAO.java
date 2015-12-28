package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardPostgreDAO implements RewardDAO {

	@Override
	public void clear() {
		HibernateUtil.executeUpdate("delete Reward");
	}

    @Override
    public Reward get(int index) {
    	return HibernateUtil.get("from Reward where id = ?", index);
    }

    @Override
    public void add(Reward element) {
    	HibernateUtil.save(element);
    }

    @Override
    public void addAll(List<Reward> elements) {
    	HibernateUtil.save(elements);
    }

    @Override
    public List<Reward> getAll() {
    	return HibernateUtil.getList("from Reward");
    }

    @Override
    public List<Reward> getByProject(int projectId) {
    	return HibernateUtil.getList("from Reward where project.id = ?", projectId);
    }

}
