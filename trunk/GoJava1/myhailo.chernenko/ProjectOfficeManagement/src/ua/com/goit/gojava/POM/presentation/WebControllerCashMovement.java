package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.postgresDB.BankAccountDAO;
import ua.com.goit.gojava.POM.persistence.postgresDB.CashMovementDAO;

@WebServlet(urlPatterns = {"/CashMovementWebController"})
public class WebControllerCashMovement extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
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

	private void loadCashMovementEntryForEdit(HttpServletRequest req) {
		
		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			CashMovementEntry cashMovementEntry = cashMovementDAO.retrieveById(id);
			req.getSession(false).setAttribute("currentEntryForEdit", cashMovementEntry);
			
		} catch (POMDataModelException | NumberFormatException e) {

			req.getSession(false).setAttribute("errorMessage", "Can not load Cash Movement Entry for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteCashMovementEntry(HttpServletRequest req) {
		
		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			cashMovementDAO.delete(cashMovementDAO.retrieveById(id));
			
		} catch (POMDataModelException | NumberFormatException e) {

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
			
			BankAccountDAO bankAccountDAO = new BankAccountDAO();
			BankAccount bankAccountRef = bankAccountDAO.retrieveById(Long.parseLong(bankAccountId));
			
			newEntry.setBankAccount(bankAccountRef);
			Money sum = new Money(Double.parseDouble(sumString),bankAccountRef.getCurrency());
			newEntry.setSum(sum );		
			
		} catch (ParseException | IllegalArgumentException | POMDataModelException e)   {

			req.getSession(false).setAttribute("errorMessage", "Could not create new Cash Movement Entry: "+e.getMessage());
			return;
			
		}
		
		CashMovementDAO cashMovementDAO = new CashMovementDAO();
		try {
			
			cashMovementDAO.create(newEntry);
			
		} catch (POMDataModelException e) {

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
			
			BankAccountDAO bankAccountDAO = new BankAccountDAO();
			BankAccount bankAccountRef = bankAccountDAO.retrieveById(Long.parseLong(bankAccountId));
			
			cashMovementEntry.setBankAccount(bankAccountRef);
			Money sum = new Money(Double.parseDouble(sumString),bankAccountRef.getCurrency());
			cashMovementEntry.setSum(sum );
			
			CashMovementDAO cashMovementDAO = new CashMovementDAO();
			cashMovementDAO.update(cashMovementEntry);
			
		} catch (POMDataModelException | ParseException | NumberFormatException e)   {

			req.getSession(false).setAttribute("errorMessage", "Could not update Cash Movement Entry: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentEntryForEdit", null);
		
	}

}
