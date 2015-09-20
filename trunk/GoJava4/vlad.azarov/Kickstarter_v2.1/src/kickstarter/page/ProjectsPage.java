
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kickstarter.logic.ProjectsLogic;
import kickstarter.model.Category;
import kickstarter.model.Project;
import kickstarter.printer.Printer;
import kickstarter.reader.Reader;
import kickstarter.repos.Repository;

public class ProjectsPage implements IPage{
	private static List<Integer> inputCheck = new ArrayList<Integer>();
	private Printer printer;
	private Reader reader;
	private ProjectsLogic projectsLogic;
	private Repository repository;
	private String header;
	private String data;
	private String footer;
	private String exit;
	private String error;
	public IPage previousPage;
	
	public ProjectsPage(Printer printer, Reader reader, Repository repository) {
		this.printer = printer;
		this.reader = reader;
		this.projectsLogic = new ProjectsLogic(repository);
		this.repository = repository;
		this.previousPage = null;
		header = "Please enter a number of project for more information"
				+ " or press \"0\" to see project menu:\n\n"
				+ "You have chosen category ";
		data = "";
		footer = "---------------";
		exit = "";
		error = "Invalid input number!!! Try again";
	}
	
	public void run(Map<String, String> choice){
		if (data == "") {
			int categoryChoice = Integer.parseInt(choice.get("categoryChoice"));
			addHeader(projectsLogic.getCategory(categoryChoice - 1));
			showHeader();
			for (int index = 0; index < projectsLogic.getSize(); index++) {
					if (categoryChoice == projectsLogic.getProject(index).getCategory()
							.getId()) {
					inputCheck.add(index + 1);
					addData(projectsLogic.getProject(index));
				}
			}
			showData();
			showFooter();
		} else {
			showHeader();
			showData();
			showFooter();
		}
	}
	
	public State makeChoice(Map<String, String> choice) throws IOException{
		int projectChoice = new InputData(printer, reader).inputData(projectsLogic
				.getSize());
		choice.put("projectChoice", Integer.toString(projectChoice));
		if (projectChoice == 0) {
			showFooter();
			inputCheck.clear();
			return State.CATEGORIES;
		} else if (inputCheck.contains(projectChoice)) { 
			return State.PROJECT_INFO;
		} else {
			showError();
			showFooter();
			showHeader();
			showData();
			return makeChoice(choice);
		}
	}
	
	private void showHeader() {
		printer.println(header);
	}

	private void addHeader(Category category) {
		header += category.toString() + "\n";
	}

	private void addData(Project project) {
		data += project.toString() + "\n";
	}
	
	
	private void showData() {
		printer.println(data);
	}

	private void showFooter() {
		printer.println(footer);
	}

	private void showError() {
		printer.println(error);
	}
}

