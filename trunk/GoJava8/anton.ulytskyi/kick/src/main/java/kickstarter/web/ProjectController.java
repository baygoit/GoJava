package kickstarter.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kickstarter.manager.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

	private static final int MAX_INVEST = 100000;
	Manager operator = new Manager();

	@RequestMapping(value = "type/selected/{id}", method = RequestMethod.GET)
	public String selectProject(@PathVariable("id") String id, ModelMap model) {

		Manager operator = new Manager();

		List<String> project = operator.openProject(Integer.parseInt(id));

		model.addAttribute("project", project);
		model.addAttribute("projectId", id);

		return "Project";

	}

	@RequestMapping(value = "type/selected/{id}", method = RequestMethod.POST)
	public String openProject(HttpServletRequest req, HttpServletRequest resp) {

		String id = req.getParameter("projectId");
		String amount = req.getParameter("invest");
		String author = req.getParameter("author");
		String text = req.getParameter("text");

		if (isWriteNumber(amount)) {
			int cash = Integer.parseInt(amount);
			try {
				operator.sponsor(Integer.parseInt(id), cash);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		if ((!author.equals("author") && !author.equals(null) && !author
				.equals(""))
				&& (!text.equals("text") || !text.equals(null) || !text
						.equals(""))) {
			try {
				// broker.say(Integer.parseInt(id), author, text);
				operator.addCommentTo(Integer.parseInt(id), author, text);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		// resp.sendRedirect("selected?" + id);
		return "redirect:" + id;
	}

	private boolean isWriteNumber(String amount) {
		int test;
		try {
			test = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			return false;
		}
		if (test > 0 && test < MAX_INVEST) {
			return true;
		} else {
			return false;
		}
	}

}
