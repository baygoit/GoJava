package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

@Repository
public class PaymentPostgreDAO implements PaymentDAO {
	@Autowired
	private HibernateUtil hiberUtil;

	@Override
	public void clear() {
		hiberUtil.executeUpdate("delete Payment");
	}

	@Override
	public Payment get(int index) {
		return hiberUtil.get("from Payment where id = ?", index);
	}

	@Override
	public void add(Payment element) {
		hiberUtil.save(element);
	}

	@Override
	public void addAll(List<Payment> elements) {
		hiberUtil.save(elements);
	}

	@Override
	public List<Payment> getAll() {
		return hiberUtil.getList("from Payment");
	}

	@Override
	public List<Payment> getByProject(int projectId) {
		return hiberUtil.getList("from Payment where project.id = ?", projectId);
	}

	@Override
	public long getSum(int projectId) {
		Long sum = hiberUtil.get("select SUM(P.sum) from Payment P where P.project.id = ?", projectId);
		if (sum == null) {
			sum = 0L;
		}
		return sum;
	}
	
}
