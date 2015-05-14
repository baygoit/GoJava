package datasource;

import java.util.ArrayList;

import entities.Category;
import entities.Project;

public interface DataSource {

	ArrayList<Category> getCategoriesList();

	String getSomeQuote();

	ArrayList<Project> getProjectsList();

	String getCategoryName(int categoryIndex);

	Project getProject(int category, int project);

}
