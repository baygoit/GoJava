package com.ivanpozharskyi.kickstarter.entity;

public class Quote {
	private String name;
	private int id;

	public Quote(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public Quote(int id, String name){
		this(name);
		this.id = id;
	}
	@Override
	public String toString() {

		return name;
	}

}
