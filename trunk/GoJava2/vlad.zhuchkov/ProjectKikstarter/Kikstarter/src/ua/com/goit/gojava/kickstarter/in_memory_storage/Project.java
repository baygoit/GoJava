package ua.com.goit.gojava.kickstarter.in_memory_storage;

public interface Project {

	ProjectParameters getParameters();

	void increaseAmount(int amount);

	String getName();

	String getDescription();

}