package ua.com.goit.gojava7.kickstarter.templates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractTemplateMemory<T> implements Templateble<T> {
	private Set<T> sourceStorage;

	public AbstractTemplateMemory() {
		sourceStorage = new TreeSet<>();
	}

	public void add(T element) {
		sourceStorage.add(element);
	}

	public void remove(T element) {
		sourceStorage.remove(element);
	}

	public Set<T> getAll() {
		return sourceStorage;
	}

	public List<T> convertSetInList(Set<T> source) {
		List<T> listOfSources = new ArrayList<>();

		Iterator<T> quotesIterator = source.iterator();
		
		while (quotesIterator.hasNext()) {
			listOfSources.add(quotesIterator.next());
		}
		
		return listOfSources;
	}
}