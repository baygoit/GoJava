package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.cashSubsystem.BankAccount;
import ua.com.goit.gojava.POM.persistence.DataManager;
import ua.com.goit.gojava.POM.persistence.LazyDataManager;
import ua.com.goit.gojava.POM.persistence.abstraction.GenericDAO;

@WebServlet(urlPatterns = {"/BankAccountWebController"})
public class WebControllerBankAccount extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew")!=null) {
		
			String name = req.getParameter("name");
			String bankName = req.getParameter("bankName");
			String currencyCode = req.getParameter("currency");
			
			DataManager dataManager = LazyDataManager.getInstance();
			GenericDAO<BankAccount> genericDAO = new GenericDAO<BankAccount>(BankAccount.class, dataManager);
			BankAccount newBankAccount= genericDAO.create();
			newBankAccount.setName(name);
			newBankAccount.setBankName(bankName);
			newBankAccount.setCurrency(Currency.getInstance(currencyCode));
				
			dataManager.saveData();
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			long id = Long.parseLong(req.getParameter("DellCurrent"));
			
			DataManager dataManager = LazyDataManager.getInstance();
			GenericDAO<BankAccount> genericDAO = new GenericDAO<BankAccount>(BankAccount.class, dataManager);
			genericDAO.delete(genericDAO.getByID(id));
			
			dataManager.saveData();
		}
		
		resp.sendRedirect(req.getHeader("referer"));
	}

	
}
