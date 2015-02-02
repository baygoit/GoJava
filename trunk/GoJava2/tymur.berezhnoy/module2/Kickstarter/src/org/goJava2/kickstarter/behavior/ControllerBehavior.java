package org.goJava2.kickstarter.behavior;

public interface ControllerBehavior<T> {
	public Object passContentToView();
	public Object passSpecificContentToView(T t);
}