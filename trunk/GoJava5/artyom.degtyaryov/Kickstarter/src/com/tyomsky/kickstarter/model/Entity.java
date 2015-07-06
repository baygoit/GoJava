package com.tyomsky.kickstarter.model;

public abstract class Entity {
	
	protected int id;
	protected String name;
	
	public Entity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

}
