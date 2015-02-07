package org.goJava2.kickstarter.behavior;

public interface StorageBehavior<T> {
	public Object getContent();
	public Object getSpecificContent(T t);
	public void addContent(Object o);
}