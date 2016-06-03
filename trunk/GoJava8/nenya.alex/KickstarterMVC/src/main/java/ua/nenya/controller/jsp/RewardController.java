package ua.nenya.controller.jsp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ua.nenya.dao.PaymentDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RequestMapping(value = "/reward")
@Controller
public class RewardController {
	
	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private RewardDao rewardDao;
	
	private static final Logger logger = LoggerFactory.getLogger(RewardController.class);

	@RequestMapping(value = "/{rewardId}", method = RequestMethod.GET)
	public String showPaymentForm(@PathVariable Long rewardId, Map<String, Object> model) {
		if (!rewardDao.isRewardExist(rewardId)) {
			logger.error("Reward with id "+rewardId+" dosen't exist!");
			model.put("rewardId", rewardId);
			return "404Page";
		}

		Project project = rewardDao.getProjectByRewardId(rewardId);
		model.put("project", project);
		model.put("quote", quoteDao.getRandomQuote());

		Reward reward =  rewardDao.getRewardByRewardId(rewardId);
		model.put("reward", reward);
		
		model.put("rewardForm", new Reward());
		return "rewardPage";
	}

	@RequestMapping(value = "/addReward", method = RequestMethod.POST)
	public String addPayment(@Valid @ModelAttribute("rewardForm") Reward reward, BindingResult result,
			Map<String, Object> model) {
		Long projectId = reward.getProject().getId();
		if (result.hasErrors()) {
			logger.error("Result "+result+" has errors!" );
			
			model.put("project", reward.getProject());
			model.put("reward", reward);
			model.put("quote", quoteDao.getRandomQuote());
			return "rewardPage";
		}

		Payment payment = new Payment();
		payment.setAmount(reward.getAmount());
		payment.setCardholderName(reward.getCardholderName());
		payment.setCardNumber(reward.getCardNumber());
		payment.setProject(reward.getProject());
		
		paymentDao.writePaymentInProject(payment);
		
		return "redirect:/project/"+projectId;
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView handleTypeMismatchException(HttpServletRequest request, TypeMismatchException ex) {
		logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex);
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
         
        modelAndView.setViewName("errorPage");
        return modelAndView;
	}
	
}
