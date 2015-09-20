package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.PaymentDocumentService;
import ua.com.goit.gojava.POM.services.ProjectService;
import ua.com.goit.gojava.POM.services.ProjectStageService;

@Configurable(autowire=Autowire.BY_TYPE)
@WebServlet(urlPatterns = {"/PaymentDocumentWebController"})
public class WebControllerPaymentDocument extends HttpServlet {

	private static final long serialVersionUID = -8446039580702580189L;
	private static final Logger LOG=Logger.getLogger(WebControllerPaymentDocument.class);
	@Inject
	private PaymentDocumentService paymentDocumentService;
	@Inject
	private CostItemService costItemService;
	@Inject
	private ProjectService projectService;
	@Inject
	private ProjectStageService projectStageService;
	@Inject
	private BankAccountService bankAccountService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	public PaymentDocumentService getPaymentDocumentService() {
		return paymentDocumentService;
	}

	public void setPaymentDocumentService(PaymentDocumentService paymentDocumentService) {
		this.paymentDocumentService = paymentDocumentService;
	}

	public CostItemService getCostItemService() {
		return costItemService;
	}

	public void setCostItemService(CostItemService costItemService) {
		this.costItemService = costItemService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public ProjectStageService getProjectStageService() {
		return projectStageService;
	}

	public void setProjectStageService(ProjectStageService projectStageService) {
		this.projectStageService = projectStageService;
	}

	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}

	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			req.getSession(false).setAttribute("currentPaymentDocumentForEdit", new PaymentDocument());
			resp.sendRedirect("PaymentDocument.jsp");
		
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deletePaymentDocument(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			setCurrentDocToSession(req);
			resp.sendRedirect("PaymentDocument.jsp");
		
		} else if (req.getParameter("DellCurrentDetail")!=null) {
			
			updateDocProperties(req);
			markForDeleteDocDetail(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrentDetail")!=null) {
			
			updateDocProperties(req);
			editCurrentDocDetail(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditDocDetail")!=null) {
			
			updateDocProperties(req);
			updateDocDetail(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("UndoEditDocDetail")!=null) {
			
			updateDocProperties(req);
			req.getSession(false).setAttribute("currentDocDetailForEdit", null);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("AddNewDetail")!=null) {
			
			updateDocProperties(req);
			createDocDetail(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("SaveDoc")!=null) {
			
			updateDocProperties(req);
			saveDoc(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("Cancel")!=null) {
			
			cancelEditing(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("ToDocList")!=null) {
			
			resp.sendRedirect("PaymentDocumentList.jsp");
			
		}
		
	}

	private void updateDocProperties(HttpServletRequest req) {

		String dateString = req.getParameter("date");
		String bankAccountId = req.getParameter("bankAccount");
		String description = req.getParameter("description");
		
		PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
		
		if(paymentDocument == null) {
			
			LOG.error("Payment Document not found in session scope.");
			req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
		
		} else {
		
			try {
				
				String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
				paymentDocument.setDate(dateFormatter.parse(dateString));
				
				if(!((bankAccountId == null) || bankAccountId.isEmpty())) {
					BankAccount bankAccount = bankAccountService.retrieveById(Long.parseLong(bankAccountId));
					paymentDocument.setBankAccount(bankAccount);
				}
				
				paymentDocument.setDescription(description);
				
			} catch (ParseException | NumberFormatException | POMServicesException e) {

				LOG.error("Could not update Doc properties: "+e.getMessage(),e);
				req.getSession(false).setAttribute("errorMessage", "Could not update Doc properties: "+e.getMessage());
				return;
				
			}
			
		}
		
	}

	private void setCurrentDocToSession(HttpServletRequest req) {
		
		PaymentDocument paymentDocument = null;
		
		if(!req.getParameter("EditCurrent").isEmpty()) {
		
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			try {
				paymentDocument = paymentDocumentService.retrieveDocById(id);
			} catch (POMServicesException e) {
				LOG.error("Can not retrieve Payment Document: "+e.getMessage(),e);
				req.getSession(false).setAttribute("errorMessage", "Can not retrieve Payment Document: "+e.getMessage());
				return;	
			}
		}
		
		req.getSession(false).setAttribute("currentPaymentDocumentForEdit", paymentDocument);
		
	}

	private void deletePaymentDocument(HttpServletRequest req) {
		
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			paymentDocumentService.deleteDoc(paymentDocumentService.retrieveDocById(id));
			
		} catch (POMServicesException | NumberFormatException e) {

			LOG.error("Can not delete Payment Document: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete Payment Document: "+e.getMessage());
			return;	
		}
		
	}

	private void markForDeleteDocDetail(HttpServletRequest req) {
		
		if(!req.getParameter("DellCurrentDetail").isEmpty()) {
		
			long rowNumber = Long.parseLong(req.getParameter("DellCurrentDetail"));
			PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
			
			if(paymentDocument == null) {
				
				LOG.error("Payment Document not found in session scope.");
				req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
				
			} else {
				
				PaymentDocumentDetail detail  = paymentDocument.getPaymentDetailByRowNumber(rowNumber);
				if(detail != null) {
					detail.setMarkedForDelete(true);
				}
			}
	
		}
		
	}
	
	private void editCurrentDocDetail(HttpServletRequest req) {
		
		if(!req.getParameter("EditCurrentDetail").isEmpty()) {
		
			long rowNumber = Long.parseLong(req.getParameter("EditCurrentDetail"));
			PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
			
			if(paymentDocument == null) {
				
				LOG.error("Payment Document not found in session scope.");
				req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
				
			} else {
				
				PaymentDocumentDetail detail  = paymentDocument.getPaymentDetailByRowNumber(rowNumber);
				req.getSession(false).setAttribute("currentDocDetailForEdit", detail);
			
			}
	
		}
		
	}
	
	private void updateDocDetail(HttpServletRequest req) {
		
		String projectId = req.getParameter("project");
		String projectStageId = req.getParameter("projectStage");
		String costItemId = req.getParameter("costItem");
		String currencyString = req.getParameter("currency");
		String sumString = req.getParameter("sum");
		
		if(!req.getParameter("EditCurrentDetail").isEmpty()) {
		
			long rowNumber = Long.parseLong(req.getParameter("EditCurrentDetail"));
			PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
			
			if(paymentDocument == null) {
				
				LOG.error("Payment Document not found in session scope.");
				req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
				
			} else {
				
				PaymentDocumentDetail detail  = paymentDocument.getPaymentDetailByRowNumber(rowNumber);
				
				try {
					
					if(!((costItemId == null) || costItemId.isEmpty())) {
						CostItem costItemRef = costItemService.retrieveById(Long.parseLong(costItemId));
						detail.setCostItem(costItemRef);
					}
					if(!((projectId == null) || projectId.isEmpty())) {
						Project projectRef = projectService.retrieveById(Long.parseLong(projectId));
						detail.setProject(projectRef);
					}
					if(!((projectStageId == null) || projectStageId.isEmpty())) {
						ProjectStage projectStageRef = projectStageService.retrieveById(Long.parseLong(projectStageId));
						detail.setProjectStage(projectStageRef);
					}
					Currency currency = Currency.getInstance(currencyString);
					Money sum = new Money(Double.parseDouble(sumString),currency);
					detail.setSum(sum);
					
				} catch (IllegalArgumentException | POMServicesException | POMDataModelException e)   {

					LOG.error("Could not change Document Details properties: "+e.getMessage(),e);
					req.getSession(false).setAttribute("errorMessage", "Could not change Document Details properties: "+e.getMessage());
					return;
					
				}
				req.getSession(false).setAttribute("currentDocDetailForEdit", null);
			
			}
	
		}
		
	}

	private void createDocDetail(HttpServletRequest req) {
		
		String projectId = req.getParameter("project");
		String projectStageId = req.getParameter("projectStage");
		String costItemId = req.getParameter("costItem");
		String currencyString = req.getParameter("currency");
		String sumString = req.getParameter("sum");
		
		if(!req.getParameter("AddNewDetail").isEmpty()) {
		
			PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
			
			if(paymentDocument == null) {
				
				LOG.error("Payment Document not found in session scope.");
				req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
				
			} else {
				
				PaymentDocumentDetail detail  = paymentDocument.addNewDetail();
				
				try {
					
					if(!((costItemId == null) || costItemId.isEmpty())) {
						CostItem costItemRef = costItemService.retrieveById(Long.parseLong(costItemId));
						detail.setCostItem(costItemRef);
					}
					if(!((projectId == null) || projectId.isEmpty())) {
						Project projectRef = projectService.retrieveById(Long.parseLong(projectId));
						detail.setProject(projectRef);
					}
					if(!((projectStageId == null) || projectStageId.isEmpty())) {
						ProjectStage projectStageRef = projectStageService.retrieveById(Long.parseLong(projectStageId));
						detail.setProjectStage(projectStageRef);
					}
					Currency currency = Currency.getInstance(currencyString);
					Money sum = new Money(Double.parseDouble(sumString),currency);
					detail.setSum(sum);
					
				} catch (IllegalArgumentException | POMServicesException | POMDataModelException e)   {

					LOG.error("Could not set Document Details properties: "+e.getMessage(),e);
					req.getSession(false).setAttribute("errorMessage", "Could not set Document Details properties: "+e.getMessage());
					return;
					
				}
			
			}
	
		}
		
	}

	private void saveDoc(HttpServletRequest req) {
		
		if(!req.getParameter("SaveDoc").isEmpty()) {
		
			PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
			
			if(paymentDocument == null) {
				
				LOG.error("Payment Document not found in session scope.");
				req.getSession(false).setAttribute("errorMessage", "Payment Document not found. Please reload the page.");
				
			} else {
				
				try {
					
					if(paymentDocument.getId() == 0){
						paymentDocumentService.createDoc(paymentDocument);
					} else {
						paymentDocumentService.updateDoc(paymentDocument);
					}
					
				} catch (POMServicesException e)   {

					LOG.error("Could not save Document: "+e.getMessage(),e);
					req.getSession(false).setAttribute("errorMessage", "Could not save Document:"+e.getMessage());
					return;
					
				}	
				
			}
	
		}
		
	}

	private void cancelEditing(HttpServletRequest req) {
		
		PaymentDocument paymentDocument = (PaymentDocument) req.getSession(false).getAttribute("currentPaymentDocumentForEdit");
		if(paymentDocument.getId() == 0) {
			
			req.getSession(false).setAttribute("currentPaymentDocumentForEdit", new PaymentDocument());
			
		} else {
			
			req.setAttribute("EditCurrent", paymentDocument.getId());
			setCurrentDocToSession(req);
		}
	
	}
}
