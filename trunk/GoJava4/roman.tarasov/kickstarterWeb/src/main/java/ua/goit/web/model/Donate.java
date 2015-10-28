package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ua.goit.web.model.dao.Bank;
import ua.goit.web.model.dao.BankException;
import ua.goit.web.model.dao.KickstarterException;
import ua.goit.web.model.dao.Project;

public class Donate extends ModelService implements IConcreteService {
	private Bank bank;

	public Donate() {
		super.model = this;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String getJspName() {
		return "Donate.jsp";
	}

	@Override
	public void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException {
		setAttributesFromParameters(request);

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

		try {
			balanceBefore = bank.getBalance(bankLogin, bankCardNumber);
		} catch (BankException e1) {
			throw new KickstarterException(e1.toString(), e1);
		}

		getMoney = Double.parseDouble(bankPay);
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

		Project project = dao.getProjectById((Integer) request
				.getAttribute("project"));

		project.setPledged(project.getPledged() + getMoney);
		dao.updateProject(project);

		request.setAttribute("balanceBefore", balanceBefore);
		request.setAttribute("balanceAfter", balanceAfter);

	}
}
