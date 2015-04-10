package ua.com.goit.gojava.POM.persistence.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class PaymentDocumentDetailDAO extends AbstractDAO<PaymentDocumentDetail> {
	
	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailDAO.class);
	
	public PaymentDocumentDetailDAO() {
		super(PaymentDocumentDetail.class);
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
	protected PaymentDocumentDetail getNewObject() {

		return new PaymentDocumentDetail();	
	}

	public List<PaymentDocumentDetail> retrieveAllByDoc(PaymentDocument doc) throws POMPersistenceException {

		Session session = getSession();
		
		try {
			
			@SuppressWarnings("unchecked")
			List<PaymentDocumentDetail> resultList = session.createCriteria(PaymentDocumentDetail.class)
													.add(Restrictions.eq("doc", doc))
													.list();
			return resultList;	
			
		} catch (HibernateException e) {
			getLog().error("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
			throw new POMPersistenceException("Could not retrieve all "+getClassName()+"s: "+e.getMessage(), e);
		} finally {
			closeSession(session);
	 	}
	
	}
	
}
