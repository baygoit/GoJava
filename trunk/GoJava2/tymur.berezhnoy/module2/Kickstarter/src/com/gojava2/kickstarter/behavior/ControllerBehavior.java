package com.gojava2.kickstarter.behavior;

public interface ControllerBehavior<T> {
	Object getContent();
	Object getSpecificContent(T t);
}