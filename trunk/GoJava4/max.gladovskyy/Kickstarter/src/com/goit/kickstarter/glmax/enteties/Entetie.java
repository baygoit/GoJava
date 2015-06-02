package com.goit.kickstarter.glmax.enteties;

public abstract class Entetie {
	
	protected int id;
	protected String name;
	
	public Entetie(int id, String name) {
		super();
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
