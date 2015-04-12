package ua.com.goit.gojava2.vova.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava2.vova.kickstarter.model.Donation;
import ua.com.goit.gojava2.vova.kickstarter.model.Donator;
import ua.com.goit.gojava2.vova.kickstarter.service.DonationService;
import ua.com.goit.gojava2.vova.kickstarter.service.DonatorService;
import ua.com.goit.gojava2.vova.kickstarter.service.ProjectService;

@Controller
@RequestMapping("/")
public class DonateController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	DonatorService donatorService;
	
	@Autowired
	DonationService donationService;
	
	@RequestMapping(value = "/donate/{id}", method = RequestMethod.GET)
	public String donate(ModelMap model, @PathVariable int id) {
		model.addAttribute("id", id);
		return "donate";
	}

	@RequestMapping(value = "/adddonate/{idProject}/{amount}", method = RequestMethod.GET)
	public String showDonationChoice(ModelMap model, @PathVariable int idProject, @PathVariable int amount) {
		return "adddonate";
	}
	
	@RequestMapping(value = "/adddonate/{idProject}/{amount}", method = RequestMethod.POST)
	public String saveDonate(ModelMap model, @PathVariable int idProject, HttpServletRequest req) {
		int amount = Integer.parseInt(req.getParameter("amount"));
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		long card = Long.valueOf(req.getParameter("card")).longValue();
		
		Donator donator = new Donator(name, mail, card);
		donatorService.saveDonator(donator);
		
		Donation donation = new Donation(donator.getId(), idProject, amount);
		donationService.saveDonation(donation);
		
		model.addAttribute("idProject", idProject);
		projectService.addDonate(amount, idProject);
		model.addAttribute("message", "Donate " + amount + " successfully");
		return "redirect:/projects/{idProject}?show";
	}
}
