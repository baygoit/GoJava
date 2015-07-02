package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ua.goit.web.model.dao.Bank;
import ua.goit.web.model.dao.BankException;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;

public class Invest extends ModelService implements IConcreteService {
	private Bank bank;

	public Invest() {
		super.model = this;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String getJspName() {
		return "Invest.jsp";
	}

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		setAttributesFromParameters(request);
		Project project = dao.getProjectById((Integer) request
				.getAttribute("project"));
		request.setAttribute("detailedProject", project);
		Integer optionIndex = (Integer) request.getAttribute("option");
		if (optionIndex != null) {
			if (optionIndex >= 0
					&& optionIndex < project.getInvestmentOptions().length) {
				request.setAttribute("correctOption", optionIndex);
			} else {
				request.setAttribute("correctOption", null);
			}
		} else {
			request.setAttribute("correctOption", null);
		}
	}

	@Override
	public void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException {
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			throw new KickstarterException("only for registered user");
		}

		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		setAttributesFromParameters(request);
		String bankLogin = request.getParameter("bankLogin");
		String bankCardNumber = request.getParameter("bankCardNumber");
		String bankPay = request.getParameter("bankPay");
		Project project = dao.getProjectById((Integer) request
				.getAttribute("project"));
		Double[] projectAmount = project.getAmount();
		Integer option = (Integer) request.getAttribute("option");

		if (projectAmount.length <= option && option < 0) {
			throw new KickstarterException("incorrect option");
		}
		Double selectedAmount = projectAmount[option];
		Double pay = null;
		try {
			pay = Double.valueOf(bankPay);
		} catch (NumberFormatException e) {
			throw new KickstarterException("incorrect format of Pay ");
		}
		double doublePay = pay;
		double doubleSelectedAmount = selectedAmount;

		if (doublePay != doubleSelectedAmount) {
			throw new KickstarterException("incorrect Pay ");
		}
		try {
			balanceBefore = bank.getBalance(bankLogin, bankCardNumber);
		} catch (BankException e1) {
			throw new KickstarterException(e1.toString(), e1);
		}

		getMoney = selectedAmount;
		try {
			bank.getMoney(bankLogin, bankCardNumber, bankPay);
		} catch (BankException e) {
			throw new KickstarterException(e.toString(), e);
		}
		try {
			balanceAfter = bank.getBalance(bankLogin, bankCardNumber);
		} catch (BankException e) {
			throw new KickstarterException(e.toString(), e);
		}
		project.setPledged(project.getPledged() + getMoney);
		dao.updateProject(project);

		request.setAttribute("balanceBefore", balanceBefore);
		request.setAttribute("balanceAfter", balanceAfter);
	}
}
