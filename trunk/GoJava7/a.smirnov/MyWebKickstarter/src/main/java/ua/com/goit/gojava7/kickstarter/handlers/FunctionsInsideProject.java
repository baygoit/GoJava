package ua.com.goit.gojava7.kickstarter.handlers;

import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@Component
public class FunctionsInsideProject {

	public void saveCreatedFaq(ProjectDao projectDao, FaqDao faqDao, int projectId, String question) {
		Faq faq = new Faq();
		Project project = projectDao.getProjectById(projectId);
		faq.setProject(project);
		faq.setQuestion(question);
		faqDao.add(faq);
	}

	public void savePayment(ProjectDao projectDao, PaymentDao paymentDao, int projectId, String userName, long creditCardNumber,
			int pledge) {
		Payment payment = new Payment();
		Project project = projectDao.getProjectById(projectId);
		payment.setProject(project);
		payment.setOwnerName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setPledge(pledge);
		paymentDao.add(payment);
	}

}
