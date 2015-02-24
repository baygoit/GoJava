package gojava.Interface;

public interface Category {

	abstract Object getTitle();

	abstract String showProjects();

	abstract Object getProject(int i);

	abstract int getLength();

	abstract void addProject(String string);

}