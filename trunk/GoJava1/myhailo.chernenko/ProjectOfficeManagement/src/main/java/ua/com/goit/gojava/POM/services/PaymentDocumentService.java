package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.postgresDB.PaymentDocumentDAO;
import ua.com.goit.gojava.POM.persistence.postgresDB.PaymentDocumentDetailDAO;

public class PaymentDocumentService {

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
	
	public List<PaymentDocument> retrieveAll() throws POMDataModelException {
		return paymentDocumentDAO.retrieveAll();	
	}
	public PaymentDocument retrieveDocById(long id) throws POMDataModelException {	
		
		PaymentDocument answer = paymentDocumentDAO.retrieveById(id);
		answer.setPaymentDocumentDetails(paymentDocumentDetailDAO.retrieveAllByDocId(id));
		
		return answer;	
	}
	public void createDoc(PaymentDocument newDoc) throws POMDataModelException {
		
		paymentDocumentDAO.create(newDoc);
		for(PaymentDocumentDetail detail:newDoc.getPaymentDocumentDetails()){
			paymentDocumentDetailDAO.create(detail);
		}
		
	}
	public void updateDoc(PaymentDocument doc) throws POMDataModelException {
		
		paymentDocumentDAO.update(doc);	
		for(PaymentDocumentDetail detail:doc.getPaymentDocumentDetails()){
			
			if(detail.isMarkedForDelete()){
				paymentDocumentDetailDAO.delete(detail);
			} else {
				paymentDocumentDetailDAO.update(detail);
			}
		}
		
	}
	public void deleteDoc(PaymentDocument doc) throws POMDataModelException {
		
		for(PaymentDocumentDetail docDetail: retrieveAllDetails(doc)){
			paymentDocumentDetailDAO.delete(docDetail);
		}
		paymentDocumentDAO.delete(doc);	
		
	}
	
	public List<PaymentDocumentDetail> retrieveAllDetails(PaymentDocument doc) throws POMDataModelException {	
		return paymentDocumentDetailDAO.retrieveAllByDocId(doc.getId());	
	}
	public PaymentDocumentDetail retrieveDocDetailById(long id) throws POMDataModelException {	
		return paymentDocumentDetailDAO.retrieveById(id);	
	}
	public void createDocDetail(PaymentDocumentDetail newDocDetail) throws POMDataModelException {
		
		if(newDocDetail.getDoc().getId() == 0) {
			
			paymentDocumentDAO.create(newDocDetail.getDoc());
			paymentDocumentDetailDAO.create(newDocDetail);
			
		} else {
			
			updateDoc(newDocDetail.getDoc());
			paymentDocumentDetailDAO.create(newDocDetail);
			
		}
		
	}
	public void updateDocDetail(PaymentDocumentDetail docDetail) throws POMDataModelException {
		
		updateDoc(docDetail.getDoc());
		paymentDocumentDetailDAO.update(docDetail);
		
	}
	public void deleteDocDetail(PaymentDocumentDetail docDetail) throws POMDataModelException {
		
		paymentDocumentDetailDAO.delete(docDetail);
		
	}
	
	public void generateTransactions(PaymentDocument doc) throws POMDataModelException {
		
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
		
	}	
	public void deleteTransactions(PaymentDocument doc) throws POMDataModelException {
	
		cashMovementService.deleteAllByDoc(doc);
		projectFinResultEntryService.deleteAllByDoc(doc);
		
	}

	
	
}
