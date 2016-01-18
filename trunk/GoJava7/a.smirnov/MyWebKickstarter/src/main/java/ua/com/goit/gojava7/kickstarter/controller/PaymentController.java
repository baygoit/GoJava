package ua.com.goit.gojava7.kickstarter.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@Controller
public class PaymentController {
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@Transactional
	public String addPayment(@RequestParam(name = "projectId") int projectId, @RequestParam(name = "userName") String userName,
			@RequestParam(name = "creditCardNumber") long creditCardNumber, @RequestParam(name = "pledge") int pledge) {

		Project project = projectDao.getProjectById(projectId);
		log.info("Payment will be added to project: {}", project);
		Payment payment = new Payment();
		payment.setProject(project);

		payment.setOwnerName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setPledge(pledge);

		paymentDao.add(payment);
		log.info("Added new payment");

		return "redirect:./project?id=" + projectId;
	}
}
