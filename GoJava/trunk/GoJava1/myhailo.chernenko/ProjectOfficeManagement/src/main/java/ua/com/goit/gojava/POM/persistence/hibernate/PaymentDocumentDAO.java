package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class PaymentDocumentDAO extends AbstractDAO<PaymentDocument> {
	
	private static final String CLASS_NAME = "Payment Document"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDAO.class);
	
	public PaymentDocumentDAO() {
		super(PaymentDocument.class);
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
	protected PaymentDocument getNewObject() {
		return new PaymentDocument();	
	}

}
