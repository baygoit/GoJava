package com.ivanpozharskyi.kickstarter.entity;

public class Answer {
	private String name;
	private int id;
	private static int count = 0;

	public Answer(String name) {
		this.name = name;
		this.id = count++;
	}

	@Override
	public String toString() {
		return name;
	}
}
