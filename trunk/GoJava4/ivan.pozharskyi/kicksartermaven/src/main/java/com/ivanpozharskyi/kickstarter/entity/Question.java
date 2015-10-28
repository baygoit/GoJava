package com.ivanpozharskyi.kickstarter.entity;

public class Question {
	private String name;
	private int id;
	private static int count = 0;

	public Question(String name) {
		this.name = name;
		this.id = count++;
	}
	public int getId(){
		return id;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
