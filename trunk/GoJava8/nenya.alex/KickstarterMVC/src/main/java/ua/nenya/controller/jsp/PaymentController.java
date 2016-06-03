package ua.nenya.controller.jsp;

import java.util.List;
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
import ua.nenya.dao.ProjectDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@RequestMapping(value = "/payment")
@Controller
public class PaymentController {
	
	@Autowired
	private QuoteDao quoteDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public String showPaymentForm(@PathVariable Long projectId, Map<String, Object> model) {
		if (!projectDao.isProjectExistById(projectId)) {
			logger.error("Project with id "+projectId+" dosen't exist!");
			model.put("projectId", projectId);
			model.put("projectTestId", -1);
			return "404Page";
		}

		Project project = projectDao.getProjectByProjectId(projectId);
		model.put("project", project);
		model.put("quote", quoteDao.getRandomQuote());

		List<Reward> rewards = projectDao.getRewardsByProjectId(projectId);
		model.put("rewards", rewards);
		model.put("paymentForm", new Payment());
		return "paymentPage";
	}

	@RequestMapping(value = "/addPayment", method = RequestMethod.POST)
	public String addPayment(@Valid @ModelAttribute("paymentForm") Payment payment, BindingResult result,
			Map<String, Object> model) {
		Long projectId = payment.getProject().getId();
		if (result.hasErrors()) {
			logger.error("Result "+result+" has errors!" );
			
			model.put("project", payment.getProject());
			List<Reward> rewards = projectDao.getRewardsByProjectId(projectId);
			model.put("rewards", rewards);
			model.put("quote", quoteDao.getRandomQuote());
			return "paymentPage";
		}

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
