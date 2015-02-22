package ua.com.goit.gojava.kickstarter;


import java.util.List;

public interface Category {

	public abstract String getName();

	public abstract List<String> getProjectCatalog();

	public abstract Project getProject(int i) throws IlligalInputException;

	public abstract int size();

}