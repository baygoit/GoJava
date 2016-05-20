package ua.nenya.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RequestMapping(value = "/payment")
@Controller
public class PaymentController {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public String showPaymentForm(@PathVariable Long projectId, Map<String, Object> model) {
		if (!projectDao.isProjectExist(projectId)) {
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
			return "404";
		}

		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("project", project);

		List<Reward> rewards = projectDao.getRewardsByProjectId(projectId);
		model.put("rewards", rewards);
		model.put("paymentForm", new Payment());
		return "paymentForm";
	}

	@RequestMapping(value = "/addPayment", method = RequestMethod.POST)
	public String addPayment(@Valid @ModelAttribute("paymentForm") Payment payment, BindingResult result,
			Map<String, Object> model) {
		Long projectId = payment.getProject().getId();
		if (result.hasErrors()) {
			model.put("project", payment.getProject());
			List<Reward> rewards = projectDao.getRewardsByProjectId(projectId);
			model.put("rewards", rewards);
			return "paymentForm";
		}

		paymentDao.writePaymentInProject(payment);
		
		return "redirect:/project/"+projectId;
	}
	
}
