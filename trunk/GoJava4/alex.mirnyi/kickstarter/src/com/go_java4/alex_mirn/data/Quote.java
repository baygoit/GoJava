package com.go_java4.alex_mirn.data;

public class Quote {
	private int id;
	private String quote;

	public Quote(int id, String quote) {
		this.id = id;
		this.quote = quote;
	}

	@Override
	public String toString() {
		return quote;
	}

}