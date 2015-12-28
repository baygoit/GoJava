package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.jdbc.util.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.domain.Payment;

public class PaymentPostgreDAO implements PaymentDAO {

	@Override
	public void clear() {
		HibernateUtil.executeUpdate("delete Payment");
	}

	@Override
	public Payment get(int index) {
		return HibernateUtil.get("from Payment where id = ?", index);
	}

	@Override
	public void add(Payment element) {
		HibernateUtil.save(element);
	}

	@Override
	public void addAll(List<Payment> elements) {
		HibernateUtil.save(elements);
	}

	@Override
	public List<Payment> getAll() {
		return HibernateUtil.getList("from Payment");
	}

	@Override
	public List<Payment> getByProject(int projectId) {
		return HibernateUtil.getList("from Payment where project.id = ?", projectId);
	}

	@Override
	public long getSum(int projectId) {
		Long sum = HibernateUtil.get("select SUM(P.sum) from Payment P where P.project.id = ?", projectId);
		if (sum == null) {
			sum = 0L;
		}
		return sum;
	}
	
}
