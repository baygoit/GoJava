package com.kickstarter.manager;

import java.util.Map;

interface Manager <T> {

	public Map<T , T> getAll(String categoryTitle);
	


	abstract public Map<T, T> getOne();



}