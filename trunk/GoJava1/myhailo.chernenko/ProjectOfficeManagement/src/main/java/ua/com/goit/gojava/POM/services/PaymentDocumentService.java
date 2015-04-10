package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.PaymentDocumentDAO;
import ua.com.goit.gojava.POM.persistence.hibernate.PaymentDocumentDetailDAO;

public class PaymentDocumentService {

	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateService.class);
	private PaymentDocumentDAO paymentDocumentDAO;
	private PaymentDocumentDetailDAO paymentDocumentDetailDAO;
	private CashMovementService cashMovementService;
	private ProjectFinResultEntryService projectFinResultEntryService;
	
	public PaymentDocumentDAO getPaymentDocumentDAO() {
		return paymentDocumentDAO;
	}
	public void setPaymentDocumentDAO(PaymentDocumentDAO paymentDocumentDAO) {
		this.paymentDocumentDAO = paymentDocumentDAO;
	}
	public PaymentDocumentDetailDAO getPaymentDocumentDetailDAO() {
		return paymentDocumentDetailDAO;
	}
	public void setPaymentDocumentDetailDAO(PaymentDocumentDetailDAO paymentDocumentDetailDAO) {
		this.paymentDocumentDetailDAO = paymentDocumentDetailDAO;
	}
	public CashMovementService getCashMovementService() {
		return cashMovementService;
	}
	public void setCashMovementService(CashMovementService cashMovementService) {
		this.cashMovementService = cashMovementService;
	}
	public ProjectFinResultEntryService getProjectFinResultEntryService() {
		return projectFinResultEntryService;
	}
	public void setProjectFinResultEntryService(
			ProjectFinResultEntryService projectFinResultEntryService) {
		this.projectFinResultEntryService = projectFinResultEntryService;
	}
	
	public List<PaymentDocument> retrieveAll() throws POMServicesException {
		
		try {
			return paymentDocumentDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
		
	}
	public PaymentDocument retrieveDocById(long id) throws POMServicesException {	
		
		try {
			return paymentDocumentDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by ID",e);
		}
	}
	public void createDoc(PaymentDocument newDoc) throws POMServicesException {
		
		try {
			paymentDocumentDAO.create(newDoc);
			for(PaymentDocumentDetail detail:newDoc.getPaymentDocumentDetails()){
				paymentDocumentDetailDAO.create(detail);
			}
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
		
	}
	public void updateDoc(PaymentDocument doc) throws POMServicesException {
		
		try {
			paymentDocumentDAO.update(doc);	
			for(PaymentDocumentDetail detail:doc.getPaymentDocumentDetails()){
				
				if(detail.isMarkedForDelete()){
					paymentDocumentDetailDAO.delete(detail);
				} else {
					paymentDocumentDetailDAO.update(detail);
				}
			}
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
		
	}
	public void deleteDoc(PaymentDocument doc) throws POMServicesException {
		
		try {
			for(PaymentDocumentDetail docDetail: retrieveAllDetails(doc)){
				paymentDocumentDetailDAO.delete(docDetail);
			}
			paymentDocumentDAO.delete(doc);	
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
		
	}
	
	public List<PaymentDocumentDetail> retrieveAllDetails(PaymentDocument doc) throws POMServicesException {	
		try {
			return paymentDocumentDetailDAO.retrieveAllByDoc(doc);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all Details for Doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all Details for Doc",e);
		}
	}
	public PaymentDocumentDetail retrieveDocDetailById(long id) throws POMServicesException {	
		try {
			return paymentDocumentDetailDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve Detail for Doc: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve Detail for Doc",e);
		}
	}
	public void createDocDetail(PaymentDocumentDetail newDocDetail) throws POMServicesException {
		
		try {
			if(newDocDetail.getDoc().getId() == 0) {
			
				paymentDocumentDAO.create(newDocDetail.getDoc());
				paymentDocumentDetailDAO.create(newDocDetail);
				
			} else {
				
				updateDoc(newDocDetail.getDoc());
				paymentDocumentDetailDAO.create(newDocDetail);
				
			}
			
		} catch (POMPersistenceException e) {
			LOG.error("Could not create doc detail: "+e.getMessage(), e);
			throw new POMServicesException("Could not create doc detail",e);
		}
		
	}
	public void updateDocDetail(PaymentDocumentDetail docDetail) throws POMServicesException {
		
		try {
			updateDoc(docDetail.getDoc());
			paymentDocumentDetailDAO.update(docDetail);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update doc detail: "+e.getMessage(), e);
			throw new POMServicesException("Could not update doc detail",e);
		}
		
	}
	public void deleteDocDetail(PaymentDocumentDetail docDetail) throws POMServicesException {
		
		try {
			paymentDocumentDetailDAO.delete(docDetail);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete doc detail: "+e.getMessage(), e);
			throw new POMServicesException("Could not delete doc detail",e);
		}
		
	}
	
	public void generateTransactions(PaymentDocument doc) throws POMServicesException {
		
		try {
			deleteTransactions(doc);
		
			if((doc != null) && (doc.getBankAccount() != null)) {
				
				CashMovementEntry newEntry = new CashMovementEntry();
				newEntry.setDate(doc.getDate());
				newEntry.setBankAccount(doc.getBankAccount());
				newEntry.setSum(doc.getDocSum());
				newEntry.setDoc(doc);
				
				cashMovementService.create(newEntry);
				
			}
			
			if( doc != null ) {
				
				for(PaymentDocumentDetail docDetail: retrieveAllDetails(doc)) {
				
					ProjectFinResultEntry newEntry = new ProjectFinResultEntry();
					
					newEntry.setDate(doc.getDate());
					newEntry.setCostItem(docDetail.getCostItem());
					newEntry.setProject(docDetail.getProject());
					newEntry.setProjectStage(docDetail.getProjectStage());
					newEntry.setSum(docDetail.getSum());
					newEntry.setDoc(doc);
					
					projectFinResultEntryService.create(newEntry);
					
				}
				
			}
			
		} catch (POMServicesException e) {
			LOG.error("Could not generate Transactions: "+e.getMessage(), e);
			throw new POMServicesException("Could not  generate Transactions",e);
		}
		
	}	
	public void deleteTransactions(PaymentDocument doc) throws POMServicesException {
	
		try {
			
			cashMovementService.deleteAllByDoc(doc);
			projectFinResultEntryService.deleteAllByDoc(doc);
		
		} catch (POMServicesException e) {
			
			LOG.error("Could not delete Transactions: "+e.getMessage(), e);
			throw new POMServicesException("Could not  delete Transactions",e);
			
		}
	}

}
