package ua.nenya.controller;

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
import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RequestMapping(value = "/reward")
@Controller
public class RewardController {

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private RewardDao rewardDao;

	@RequestMapping(value = "/{rewardId}", method = RequestMethod.GET)
	public String showPaymentForm(@PathVariable Long rewardId, Map<String, Object> model) {
		if (!rewardDao.isRewardExist(rewardId)) {
			model.put("rewardId", rewardId);
			return "404";
		}

		Project project = rewardDao.getProjectByRewardId(rewardId);
		model.put("project", project);

		Reward reward =  rewardDao.getRewardByRewardId(rewardId);
		model.put("reward", reward);
		
		model.put("rewardForm", new Reward());
		return "rewardForm";
	}

	@RequestMapping(value = "/addReward", method = RequestMethod.POST)
	public String addPayment(@Valid @ModelAttribute("rewardForm") Reward reward, BindingResult result,
			Map<String, Object> model) {
		Long projectId = reward.getProject().getId();
		if (result.hasErrors()) {
			model.put("project", reward.getProject());
			model.put("reward", reward);
			return "rewardForm";
		}

		Payment payment = new Payment();
		payment.setAmount(reward.getAmount());
		payment.setCardholderName(reward.getCardholderName());
		payment.setCardNumber(reward.getCardNumber());
		payment.setProject(reward.getProject());
		
		paymentDao.writePaymentInProject(payment);
		
		return "redirect:/project/"+projectId;
	}
	
}
