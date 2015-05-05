package com.sergiisavin.kickstarter;

public interface Quotes {


	public abstract int getSize();

	public abstract void add(String quote);

	public abstract String getRandomQuote();

	public abstract void delete(int index);

	public abstract String get(int i);

	public class IllegalArgumentException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}

}