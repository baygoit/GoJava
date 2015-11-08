package beans;

import static view.eViews.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import view.ViewDispatcher;
import view.ViewStrategy;
import dao.bank.Bank;
import dao.bank.BankSingleton;
import dao.pool.KickstarterException;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;
import dao.project.ProjectService;

public class Donate extends DatabaseConnectionChecker implements iBean {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		ViewDispatcher selectedView = ViewStrategy.getInstance().selectView(
				DONATE_V);
		selectedView.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {

		ProjectService projectService = null;
		if (connected()) {
			projectService = new DBprojectServiceImpl();
		} else {
			projectService =  DefaultProjectServiceImpl.getInstance();
		}
		double balanceBefore = 0;
		double balanceAfter = 0;
		double getMoney = 0;
		Bank bank = BankSingleton.getInstance().getBank();
		String bankLogin = request.getParameter("bankLogin");
		String bankCardNumber = request.getParameter("bankCardNumber");
		String bankPay = request.getParameter("bankPay");
		try {
			balanceBefore = bank.getBalance(bankLogin, bankCardNumber);
			getMoney = Double.parseDouble(bankPay);
			bank.getMoney(bankLogin, bankCardNumber, bankPay);
			balanceAfter = bank.getBalance(bankLogin, bankCardNumber);
			HttpSession session = request.getSession();
			Project projectFromSession = (Project) session
					.getAttribute("detailedProject");
			Project project = projectService.getProjectById(projectFromSession
					.getID());

			project.setPledged(project.getPledged() + getMoney);
			projectService.updateProject(project);
			session.setAttribute("detailedProject", project);
			request.setAttribute("balanceBefore", balanceBefore);
			request.setAttribute("balanceAfter", balanceAfter);

		} catch (Exception e) {
			throw new KickstarterException("Donate has error", e);
		}
		ViewDispatcher selectedView = ViewStrategy.getInstance().selectView(
				DONATE_V);
		selectedView.forward(request, response);

	}
}
