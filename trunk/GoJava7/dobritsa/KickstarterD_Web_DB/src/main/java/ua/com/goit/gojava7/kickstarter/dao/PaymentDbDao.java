package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Payment;

@Component
public class PaymentDbDao {

	@Autowired
	private DbDao dbDao;

	private static final Logger log = LoggerFactory.getLogger(QuestionDbDao.class);

	public PaymentDbDao() {
	}

	public void add(Payment element) {
		log.info("<void> add({})...", element);
		String query = "insert into payment (user, card, amount, project_id) values (?, ?, ?, ?)";
		dbDao.addPayment(element, query);
	}

	public List<Payment> getByProject(int projectId) {
		log.info("<Payment> getByProject({})...", projectId);
		String query = "select user, card, amount, project_id from payment where project_id = " + projectId;
		return dbDao.getPaymentsByProject(query);
	}
}
