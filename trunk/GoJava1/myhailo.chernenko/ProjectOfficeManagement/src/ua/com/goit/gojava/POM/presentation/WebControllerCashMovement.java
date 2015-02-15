package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.POM.dataModel.cashSubsystem.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cashSubsystem.CashMovementEntry;
import ua.com.goit.gojava.POM.dataModel.cashSubsystem.CashMovementStatement;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.persistence.DataManager;
import ua.com.goit.gojava.POM.persistence.LazyDataManager;
import ua.com.goit.gojava.POM.persistence.abstraction.GenericDAO;

@WebServlet(urlPatterns = {"/CashMovementWebController"})
public class WebControllerCashMovement extends HttpServlet {

	private static final long serialVersionUID = 4965130230495295419L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		CashMovementStatement statement = (CashMovementStatement) req.getSession().getAttribute("CashMovementStatementHolder");
		
		if ((req.getParameter("AddNew") != null)&&(statement != null)) {
			
			String date = req.getParameter("date");
			String sum = req.getParameter("sum");
			String characteristic = req.getParameter("characteristic");
			String description = req.getParameter("description");
			String doc = req.getParameter("doc");
			Currency currency = ((BankAccount) req.getSession().getAttribute("BankAccount")).getCurrency();
			
			CashMovementEntry newEntry = statement.addEntry();
			
			try {
				newEntry.setDate((new SimpleDateFormat("yyyy.MM.dd")).parse(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			
			newEntry.setDescription(description);
			//newEntry.setCharacteristic(characteristic);
			//newEntry.setDoc(doc);
			newEntry.setSum(new Money(Double.parseDouble(sum), currency));;
				
			LazyDataManager.getInstance().saveData();
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			/*long id = Long.parseLong(req.getParameter("DellCurrent"));
			
			DataManager dataManager = LazyDataManager.getInstance();
			GenericDAO<BankAccount> genericDAO = new GenericDAO<BankAccount>(BankAccount.class, dataManager);
			genericDAO.delete(genericDAO.getByID(id));
			
			dataManager.saveData();*/
		}
		
		resp.sendRedirect(req.getHeader("referer"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if ((req.getParameter("act")!=null)&&(req.getParameter("id")!=null)) {
		
			long id = Long.parseLong(req.getParameter("id"));
			
			DataManager dataManager = LazyDataManager.getInstance();
			GenericDAO<BankAccount> genericDAO = new GenericDAO<BankAccount>(BankAccount.class, dataManager);
			BankAccount bankAccount = genericDAO.getByID(id);
			req.getSession().setAttribute("BankAccount", bankAccount);
			
			if(req.getParameter("act").equals("p")) { 
			
				CashMovementStatement statement = bankAccount.getPlannedTransactions();
				
				req.getSession().setAttribute("CashMovementStatement", statement);
				req.getSession().setAttribute("CashMovementStatementHolder", statement);
				
			} else if(req.getParameter("act").equals("f")) { 
			
				CashMovementStatement statement = bankAccount.getFactTransactions();
				
				req.getSession().setAttribute("CashMovementStatement", statement);
				req.getSession().setAttribute("CashMovementStatementHolder", statement);
				
			}
			
		}
		
		resp.sendRedirect("CashMovement.jsp");
		
	}

	
}
