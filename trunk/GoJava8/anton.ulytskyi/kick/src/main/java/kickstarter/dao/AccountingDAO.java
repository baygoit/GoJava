package kickstarter.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import kickstarter.domain.Accounting;

import org.springframework.stereotype.Repository;

@Repository
public class AccountingDAO {

	@PersistenceContext
	public EntityManager emf;

	public Number getTheSumOfAccount(int id) {

		Query query = emf
				.createQuery("select sum(amount) from accounting where id='"
						+ id + "'");

		return (Number) query.getSingleResult();
	}

	public void persist(Accounting payment) {
		Accounting transaction = emf.merge(payment);

		emf.persist(transaction);
	}
	
}
