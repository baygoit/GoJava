package kickstarter.pages.viewContent;

import java.sql.SQLException;
import java.util.List;
import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.Project;
import kickstarter.mvc.viewState.ViewValues;

public class Projects extends PageView {
	private Project project;

	private String printProjectsInfo(int categoryID) throws ServiceException,
			SQLException {
		StringBuilder result = new StringBuilder();
		List<Project> sortedToSelect = idao.getProjectService()
				.sortProjectsByCategoryID(categoryID);
		int length = sortedToSelect.size();
		strValues = new String[length];
		intValues = new int[length];
		for (int index = 0; index < length; index++) {
			project = sortedToSelect.get(index);

			strValues[index] = Integer.toString(project.getID());
			intValues[index] = project.getID();

			result.append("\nID:<");
			result.append(project.getID());
			result.append("> name:<");
			result.append(project.getName());
			result.append(">\n short desc.:<");
			result.append(project.getShortDescription());
			result.append(">\n goal:<");
			result.append(project.getGoal());
			result.append(">\n pledged:<");
			result.append(project.getPledged());
			result.append(">\n days to go:<");
			result.append(project.getDaysToGo());
			result.append(">");
			result.append("\n================================");
		}
		ViewValues ViewValues = iview.getViewValues();
		ViewValues.setIntProjects(intValues);
		ViewValues.setStrProjects(strValues);
		return result.toString();
	}

	@Override
	public String getHeader() throws ServiceException, SQLException {

		StringBuilder header = new StringBuilder();
		header.append("\n________________________");
		header.append("\n|     Projects         |");
		header.append("\n|______________________|");
		header.append("\n");
		header.append(printProjectsInfo(imodel.getModelValues()
				.getIntSelectedCategory()));
		header.append("\n------------------------");
		header.append("\nSelect project by ID:<ID>");
		header.append("\nOptions:  <p> - previous page");
		return header.toString();
	}
}
