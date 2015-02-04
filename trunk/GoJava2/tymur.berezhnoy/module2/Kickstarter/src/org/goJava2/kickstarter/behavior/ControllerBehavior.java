package org.goJava2.kickstarter.behavior;

public interface ControllerBehavior<T> {
	public Object getContent();
	public Object getSpecificContent(T t);
}