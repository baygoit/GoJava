package kickstarter.service;

import kickstarter.dao.AccountingDAO;
import kickstarter.domain.Accounting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AccountingService")
@Transactional
public class AccountingService {
	@Autowired
	protected AccountingDAO dao;

	public void setDao(AccountingDAO dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public Number getTheSumOfAccount(int id) {
		return this.dao.getTheSumOfAccount(id);
	}

	public void persist(Accounting payment) {
		this.dao.persist(payment);
	}

}
