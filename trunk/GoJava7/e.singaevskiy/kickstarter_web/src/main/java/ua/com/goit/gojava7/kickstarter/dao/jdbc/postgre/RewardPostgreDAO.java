package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
public class RewardPostgreDAO implements RewardDAO {

	@Autowired
	private HibernateUtil hiberUtil;
	
	@Override
	public void clear() {
		hiberUtil.executeUpdate("delete Reward");
	}

    @Override
    public Reward get(int index) {
    	return hiberUtil.get("from Reward where id = ?", index);
    }

    @Override
    public void add(Reward element) {
    	hiberUtil.save(element);
    }

    @Override
    public void addAll(List<Reward> elements) {
    	hiberUtil.save(elements);
    }

    @Override
    public List<Reward> getAll() {
    	return hiberUtil.getList("from Reward");
    }

    @Override
    public List<Reward> getByProject(int projectId) {
    	return hiberUtil.getList("from Reward where project.id = ?", projectId);
    }

}
