package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@WebServlet(urlPatterns = {"/CashMovementWebController"})
public class WebControllerCashMovement extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;
	private static final Logger LOG=Logger.getLogger(WebControllerCashMovement.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("bankAccountFilter") != null) {
			
			setBankAccountFilter(req);
			
		} else if (req.getParameter("AddNew") != null) {
			
			createCashMovementEntry(req);
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteCashMovementEntry(req);
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadCashMovementEntryForEdit(req);
		
		} else if (req.getParameter("Edit")!=null) {
			
			updateCashMovementEntry(req);
			
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentEntryForEdit", null);
		
		}
		
		resp.sendRedirect(req.getHeader("referer"));
		
	}

	private void setBankAccountFilter(HttpServletRequest req) {
		
		BankAccount bankAccount = null;
		
		if(!req.getParameter("bankAccountFilter").isEmpty()) {
		
			BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			long id = Long.parseLong(req.getParameter("bankAccountFilter"));
			try {
				bankAccount = bankAccountService.retrieveById(id);
			} catch (POMServicesException e) {
				LOG.error("Can not retrieve Bank Account for filter: "+e.getMessage(),e);
				req.getSession(false).setAttribute("errorMessage", "Can not retrieve Bank Account for filter: "+e.getMessage());
				return;	
			}
		}
		
		req.getSession(false).setAttribute("bankAccountFilterValue", bankAccount );
	}

	private void loadCashMovementEntryForEdit(HttpServletRequest req) {
		
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			CashMovementEntry cashMovementEntry = cashMovementService.retrieveById(id);
			req.getSession(false).setAttribute("currentEntryForEdit", cashMovementEntry);
			
		} catch (POMServicesException e) {

			LOG.error("Can not load Cash Movement Entry for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load Cash Movement Entry for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteCashMovementEntry(HttpServletRequest req) {
		
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			cashMovementService.delete(cashMovementService.retrieveById(id));
			
		} catch ( NumberFormatException | POMServicesException e) {

			LOG.error("Can not delete Cash Movement Entry: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete Cash Movement Entry: "+e.getMessage());
			return;	
		}
		
	}

	private void createCashMovementEntry(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String bankAccountId = req.getParameter("bankAccount");
		String sumString = req.getParameter("sum");
		
		CashMovementEntry newEntry = new CashMovementEntry();
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			newEntry.setDate(dateFormatter.parse(dateString));
			
			BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			BankAccount bankAccountRef = bankAccountService.retrieveById(Long.parseLong(bankAccountId));
			
			newEntry.setBankAccount(bankAccountRef);
			Money sum = new Money(Double.parseDouble(sumString),bankAccountRef.getCurrency());
			newEntry.setSum(sum );		
			
		} catch (ParseException | IllegalArgumentException | POMDataModelException | POMServicesException e)   {

			LOG.error("Could not create new Cash Movement Entry: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new Cash Movement Entry: "+e.getMessage());
			return;
			
		}
		
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			
			cashMovementService.create(newEntry);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new Cash Movement Entry: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new Cash Movement Entry: "+e.getMessage());
			return;	
		}
	}
	
	private void updateCashMovementEntry(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String bankAccountId = req.getParameter("bankAccount");
		String sumString = req.getParameter("sum");
		
		CashMovementEntry cashMovementEntry = (CashMovementEntry) req.getSession(false).getAttribute("currentEntryForEdit");
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			cashMovementEntry.setDate(dateFormatter.parse(dateString));
			
			BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			BankAccount bankAccountRef = bankAccountService.retrieveById(Long.parseLong(bankAccountId));
			
			cashMovementEntry.setBankAccount(bankAccountRef);
			Money sum = new Money(Double.parseDouble(sumString),bankAccountRef.getCurrency());
			cashMovementEntry.setSum(sum );
			
			CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
			cashMovementService.update(cashMovementEntry);
			
		} catch (POMDataModelException | ParseException | NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update Cash Movement Entry: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update Cash Movement Entry: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentEntryForEdit", null);
		
	}

}
