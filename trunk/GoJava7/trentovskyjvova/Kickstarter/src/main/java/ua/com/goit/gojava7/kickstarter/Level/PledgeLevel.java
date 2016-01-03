package ua.com.goit.gojava7.kickstarter.Level;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class PledgeLevel implements Level {
	private PaymentDao paymentDao;
	private RewardDao rewardDao;
	
	public PledgeLevel(PaymentDao paymentDao, RewardDao rewardDao) {
		setPaymentDao(paymentDao);
		setRewardDao(rewardDao);
	}

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	public RewardDao getRewardDao() {
		return rewardDao;
	}

	public void setRewardDao(RewardDao rewardDao) {
		this.rewardDao = rewardDao;
	}
	
	@Override
	public String generateAnswer(int userChoise, Category selectedCategory,
			Project selectedProject) {

		return "";
	}

	@Override
	public Category findSelectedCategory(int userChoise,
			Category selectedCategory) {

		return selectedCategory;
	}

	@Override
	public String validateUserChoise(int userChoise, Category selectedCategory,
			Project selectedProject) {

		return "";
	}

	@Override
	public String fillOutForm(Project project, int userChoise,
			ConsoleScanner consoleScanner) {
		ConsolePrinter consolePrinter = new ConsolePrinter();

		int donate = 0;

		if (userChoise == rewardDao.size(project.getId()) + 1) {
			consolePrinter.print("Enter amount to donate");
			donate = consoleScanner.scan();
		} else if (userChoise > 0) {		
			Reward reward = rewardDao.getReward(userChoise, project.getId());
			donate = reward.getPledge();	
		}

		if (donate == 0) {
			return "0 : back to rewards";
		}
		consolePrinter.print("Enter your name");
		String name = consoleScanner.scanLine();
		consolePrinter.print("Enter card number");
		String cardNumber = consoleScanner.scanLine();

		Payment payment = new Payment();
		payment.setProject(project);
		payment.setName(name);
		payment.setCardNumber(cardNumber);
		payment.setPledge(donate);

		paymentDao.addPayment(payment);

		return "Thank you!\n0 : back to rewards";
	}

	@Override
	public Project findSelectedProject(int userChoise,
			Category selectedCategory, Project selectedProject) {

		return selectedProject;
	}

}
