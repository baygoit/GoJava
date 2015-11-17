package ua.com.goit.gojava7.kickstarter.templates;

import java.util.Set;

public interface Templateble<T> {
	
	public void add(T element);

	public void remove(T element);
	
	public Set<T> getAll();
	
}
