package com.gojava2.kickstarter.controller;

public interface Controller<T> {
	Object getContent();
	Object getSpecificContent(T t);
}