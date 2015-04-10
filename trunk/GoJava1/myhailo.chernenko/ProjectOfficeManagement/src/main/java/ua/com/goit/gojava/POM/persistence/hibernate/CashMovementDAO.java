package ua.com.goit.gojava.POM.persistence.hibernate;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class CashMovementDAO extends AbstractDAO<CashMovementEntry> {
	
	private static final String CLASS_NAME = "Cash Movement"; 
	private static final Logger LOG = Logger.getLogger(CashMovementDAO.class);
	
	public CashMovementDAO() {
		super(CashMovementEntry.class);
	}

	@Override
	protected String getClassName() {
		
		return CLASS_NAME;
	}

	@Override
	protected Logger getLog() {
		
		return LOG;	
	}

	@Override
	protected CashMovementEntry getNewObject() {

		return new CashMovementEntry();	
	}

	public Money getTotalByBankAccount(BankAccount bankAccount) throws POMPersistenceException {

		Money result = new Money(bankAccount.getCurrency());
		
		Session session = getSession();
		
		try {
			
			String hql = "SELECT SUM(entry.sum.value) FROM CashMovementEntry entry "
					+ "	WHERE entry.bankAccount = :bankAccount";
			Query query = session.createQuery(hql);
			query.setParameter("bankAccount", bankAccount);
			if (query.iterate().hasNext()){
				result = new Money((BigDecimal) query.uniqueResult(),bankAccount.getCurrency());
			}
		
		} catch (HibernateException | POMDataModelException e) {
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
		} finally {
			closeSession(session);
	 	}
		
		return result;
	
	}
	
	public List<CashMovementEntry> retrieveAll(BankAccount bankAccount) throws POMPersistenceException {

		Session session = getSession();
		
		try {
			
			@SuppressWarnings("unchecked")
			List<CashMovementEntry> resultList = session.createCriteria(CashMovementEntry.class)
													.add(Restrictions.eq("bankAccount", bankAccount))
													.list();
			return resultList;	
			
		} catch (HibernateException e) {
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
		} finally {
			closeSession(session);
	 	}
	
	}

	
	public void deleteAllByDoc(FinancialDocument doc) throws POMPersistenceException {

		Session session = getSession();
		try {
			
			session.beginTransaction();
			String hql = "delete from CashMovementEntry where doc= :doc";
			session.createQuery(hql).setParameter("doc",doc).executeUpdate();
            session.getTransaction().commit();
            
        } catch (HibernateException | NullPointerException e) {
			getLog().error("Could not delete "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not delete "+getClassName()+": "+e.getMessage(), e);
		} finally {
			closeSession(session);
	    }
		
	}
}
