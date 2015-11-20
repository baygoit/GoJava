package ua.com.goit.gojava7.kickstarter.dao;

public abstract class AbstractFilesStorage<T> implements Templateble<T> {
	protected static final String SEMICOLON_DELIMITER = ";";
	protected static final String NEW_LINE_SEPARATOR = "\n";
}
