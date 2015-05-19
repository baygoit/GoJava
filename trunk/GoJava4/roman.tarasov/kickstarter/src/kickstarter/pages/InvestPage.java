package kickstarter.pages;

import kickstarter.entities.Project;
import kickstarter.mvc.Model;
import kickstarter.repository.ProjectRepository;

public class InvestPage extends Page {
	Project project;

	public InvestPage(Model model, ProjectRepository projects) {
		navigator = model;
		this.projects = projects;
	}

	public String getHeader() {
		int projectID = iOption;
		project = projects.getProjectById(projectID);
		String header = "";
		header += "\n=========================";
		header += "\n|   invest to project   |";
		header += "\n=========================";
		header += "\n";
		header += "\n  Investment options :";
		int length = project.investmentOptions.length;
		optionsInt = new int[length];
		options = new String[length];
		for (int index = 0; index < length; index++) {
			String option = project.investmentOptions[index];
			header += "\n" + (index + 1) + " -" + option;
			optionsInt[index] = index + 1;
			options[index] = Integer.toString(index + 1);
		}
		header += "\n------------------------";
		header += "\nOptions: <p>- previous page  ";
		return header;
	}

	public void execute(String message) {
		navigator.setOption(iOption, "null");
		if (message.equals("p")) {
			navigator.next(DETAILED_PROJECT);
			return;
		}
		double amount = 0;
		try {
			int selected = Integer.parseInt(message);
			amount = project.amount[selected - 1];

		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			navigator.goToAndBack(ERROR_PAGE, INVEST_PAGE);
			return;
		}
	
		navigator.nextWithOptions(APPLY_TRANSACTION_PAGE, iOption, Double.toString(amount));
	}
}
