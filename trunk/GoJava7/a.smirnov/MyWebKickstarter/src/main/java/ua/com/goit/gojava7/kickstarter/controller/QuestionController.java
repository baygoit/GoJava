package ua.com.goit.gojava7.kickstarter.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.database.contract.FaqDao;
import ua.com.goit.gojava7.kickstarter.database.contract.ProjectDao;

@Controller
public class QuestionController {
	private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private FaqDao faqDao;

	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	@Transactional
	public String addQuestion(@RequestParam(name = "projectId") int projectId, @RequestParam(name = "question") String question) {
		Project project = projectDao.getProjectById(projectId);
		log.info("Question will be added to project: {}", project);

		Faq faq = new Faq();
		faq.setProject(project);
		faq.setQuestion(question);
		
		faqDao.add(faq);
		log.info("Added new question");

		return "redirect:./project?id=" + projectId;
	}
}
