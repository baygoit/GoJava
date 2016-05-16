package ua.nenya.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuestionDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@Controller
public class PaymentController {

	@Autowired
	protected ProjectDao projectDao;
	@Autowired
	protected PaymentDao paymentDao;
	@Autowired
	protected QuestionDao questionDao;

	@RequestMapping(value = "/category/project/payment/{projectId}", method = RequestMethod.GET)
	public String showRewards(@PathVariable Long projectId, Map<String, Object> model) {
		if (!projectDao.isProjectExist(projectId)) {
			model.put("projectId", projectId);
			return "404";
		}

		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("project", project);

		List<Reward> rewards = projectDao.getRewardsByProjectId(projectId);
		model.put("rewards", rewards);
		model.put("paymentForm", new Payment());
		return "payment";
	}

	@RequestMapping(value = "/category/project/payment/add", method = RequestMethod.POST)
	public String addPayment(@ModelAttribute("paymentForm") Payment payment, BindingResult result,
			Map<String, Object> model) {
		if (result.hasErrors()) {
			Project project = payment.getProject();
			model.put("project", project);
			List<Reward> rewards = projectDao.getRewardsByProjectId(project.getId());
			model.put("rewards", rewards);
			return "payment";
		}

		if (payment.getAmount() == 0) {
			Payment paymentNew = payment;
			paymentNew.setAmount(payment.getInvestment());
			paymentDao.writePaymentInProject(paymentNew);
		} else {
			paymentDao.writePaymentInProject(payment);
		}

		Long projectId = payment.getProject().getId();
		return "redirect:/category/project/"+projectId;
	}
}
