package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
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

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@Configurable(autowire=Autowire.BY_TYPE)
@WebServlet(urlPatterns = {"/BankAccountWebController"})
public class WebControllerBankAccount extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;
	private static final Logger LOG=Logger.getLogger(WebControllerBankAccount.class);
	@Inject
	private BankAccountService bankAccountService;// = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
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
		
		if (req.getParameter("OpenCashMovement") != null) {
			
			setBankAccountFilter(req);
			resp.sendRedirect("CashMovement.jsp");
			
		} else if (req.getParameter("AddNew") != null) {
			
			createBankAccount(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteBankAccount(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadBankAccountForEdit(req);
			resp.sendRedirect(req.getHeader("referer"));
			
		} else if (req.getParameter("Edit")!=null) {
			
			updateBankAccount(req);
			resp.sendRedirect(req.getHeader("referer"));
				
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentAccountForEdit", null);
			resp.sendRedirect(req.getHeader("referer"));
		
		}
		

	}

	private void setBankAccountFilter(HttpServletRequest req) {
		
		BankAccount bankAccount = null;
		
		if(!req.getParameter("OpenCashMovement").isEmpty()) {
		
			//bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			
			long id = Long.parseLong(req.getParameter("OpenCashMovement"));
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

	private void loadBankAccountForEdit(HttpServletRequest req) {
		
		//BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			BankAccount bankAccount = bankAccountService.retrieveById(id);
			req.getSession(false).setAttribute("currentAccountForEdit", bankAccount);
			
		} catch (NumberFormatException| POMServicesException e) {

			LOG.error("Can not load Bank Account for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load Bank Account for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteBankAccount(HttpServletRequest req) {
		
		//BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			bankAccountService.delete(bankAccountService.retrieveById(id));
			
		} catch (NumberFormatException | POMServicesException e) {

			LOG.error("Can not delete Bank Account: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete Bank Account: "+e.getMessage());
			return;	
		}
		
	}

	private void createBankAccount(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String bankNameString = req.getParameter("bankName");
		String currencyCode = req.getParameter("currency");
		
		BankAccount bankAccount= new BankAccount();
		
		try {
			
			bankAccount.setName(nameString);
			bankAccount.setBankName(bankNameString);
			
			if(!currencyCode.isEmpty()) {
				bankAccount.setCurrency(Currency.getInstance(currencyCode));
			}
			
		} catch (IllegalArgumentException e)   {

			LOG.error("Could not create new Bank Account: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new Bank Account: "+e.getMessage());
			return;
			
		}
		
		//BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		try {
			
			bankAccountService.create(bankAccount);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new Bank Account: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new Bank Account: "+e.getMessage());
			return;	
		}
	}
	
	private void updateBankAccount(HttpServletRequest req) {
		
		String nameString = req.getParameter("name");
		String bankNameString = req.getParameter("bankName");
		String currencyCode = req.getParameter("currency");
		
		BankAccount bankAccount = (BankAccount) req.getSession(false).getAttribute("currentAccountForEdit");
		
		try {
			
			bankAccount.setName(nameString);
			bankAccount.setBankName(bankNameString);
			
			if(!currencyCode.isEmpty()) {
				bankAccount.setCurrency(Currency.getInstance(currencyCode));
			}
			
			//BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			bankAccountService.update(bankAccount);
			
		} catch (NumberFormatException | POMServicesException e)   {

			LOG.error("Could not update Bank Account: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update Bank Account: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentAccountForEdit", null);
		
	}

}
