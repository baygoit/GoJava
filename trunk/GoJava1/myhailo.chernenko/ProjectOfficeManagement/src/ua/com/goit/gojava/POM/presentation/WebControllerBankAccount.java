package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.postgresDB.BankAccountDAO;

@WebServlet(urlPatterns = {"/BankAccountWebController"})
public class WebControllerBankAccount extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

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
		
			BankAccountDAO bankAccountDAO = new BankAccountDAO();
			long id = Long.parseLong(req.getParameter("OpenCashMovement"));
			try {
				bankAccount = bankAccountDAO.retrieveById(id);
			} catch (POMDataModelException e) {
				req.getSession(false).setAttribute("errorMessage", "Can not retrieve Bank Account for filter: "+e.getMessage());
				return;	
			}
		}
		
		req.getSession(false).setAttribute("bankAccountFilterValue", bankAccount );
	}

	private void loadBankAccountForEdit(HttpServletRequest req) {
		
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			BankAccount bankAccount = bankAccountDAO.retrieveById(id);
			req.getSession(false).setAttribute("currentAccountForEdit", bankAccount);
			
		} catch (POMDataModelException | NumberFormatException e) {

			req.getSession(false).setAttribute("errorMessage", "Can not load Bank Account for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteBankAccount(HttpServletRequest req) {
		
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			bankAccountDAO.delete(bankAccountDAO.retrieveById(id));
			
		} catch (POMDataModelException | NumberFormatException e) {

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

			req.getSession(false).setAttribute("errorMessage", "Could not create new Bank Account: "+e.getMessage());
			return;
			
		}
		
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		try {
			
			bankAccountDAO.create(bankAccount);
			
		} catch (POMDataModelException e) {

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
			
			BankAccountDAO bankAccountDAO = new BankAccountDAO();
			bankAccountDAO.update(bankAccount);
			
		} catch (POMDataModelException | NumberFormatException e)   {

			req.getSession(false).setAttribute("errorMessage", "Could not update Bank Account: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentAccountForEdit", null);
		
	}
}
