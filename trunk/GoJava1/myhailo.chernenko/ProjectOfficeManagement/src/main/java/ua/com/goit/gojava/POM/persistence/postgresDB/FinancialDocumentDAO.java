package ua.com.goit.gojava.POM.persistence.postgresDB;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;

public class FinancialDocumentDAO {

	private static final Logger LOG = Logger.getLogger(FinancialDocumentDAO.class);
	
	private PaymentDocumentDAO paymentDocumentDAO;
	
	public FinancialDocument getFinancialDocument(String docType, long docId) throws POMDataModelException {
		
		if(docType == "PaymentDocument") {
			
			return paymentDocumentDAO.retrieveById(docId);
		
		//} else if(docType == "FinancialProjectPlan") {
		//	
		//	return financialProjectPlanDAO.retrieveById(docId);
			
		} else {
			
			LOG.error("Unknown Fianacial Document type: "+docType);
			throw new POMDataModelException("Unknown Fianacial Document type: "+docType);
			
		}
		
	}

	public PaymentDocumentDAO getPaymentDocumentDAO() {
		return paymentDocumentDAO;
	}

	public void setPaymentDocumentDAO(PaymentDocumentDAO paymentDocumentDAO) {
		this.paymentDocumentDAO = paymentDocumentDAO;
	}
	
}
