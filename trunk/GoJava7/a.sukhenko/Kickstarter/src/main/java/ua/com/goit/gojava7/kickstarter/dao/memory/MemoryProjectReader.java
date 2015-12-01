package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class MemoryProjectReader {
	public Set<Project> readProjects() {
		Set<Project> projects = new HashSet<>();
		LocalDateTime dateTime = LocalDateTime.now();
		Project catana = new Project("Catana", "New sword-fighting game", 3, dateTime.plusDays(14));
		new Project("Terminator Exodus", "New game about fighting as Terminator", 1, dateTime);
		Project project = new Project("GoIT Java 7", "Movie about our GoIT Java 7 Group", 1,
				LocalDateTime.now().plusHours(23));

		catana.setDemoLink("www.catana.game");
		catana.getPaymentBonus().getBonuses().put(1, "You will be mentioned in the project");
		catana.getPaymentBonus().getBonuses().put(10, "Tea Cup with Catana + mentioned in the project");
		catana.getPaymentBonus().getBonuses().put(40, "Same as for 10$ + Early Access pack.");
		Map<String, String> qa = new HashMap<String, String>();
		qa.put("What is project about?", "It is about our goit7 group");
		qa.put("When was it started", "October 2015");
		catana.setQuestionsAndAnswers(qa);
		
		projects.add(project);
		projects.add(catana);
		
		return projects;
	}
}
