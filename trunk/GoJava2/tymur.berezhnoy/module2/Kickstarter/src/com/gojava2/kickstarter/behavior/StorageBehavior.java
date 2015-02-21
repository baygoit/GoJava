package com.gojava2.kickstarter.behavior;

public interface StorageBehavior<T> {
	Object getContent();
	Object getSpecificContent(T t);
	void addContent(Object o);
}