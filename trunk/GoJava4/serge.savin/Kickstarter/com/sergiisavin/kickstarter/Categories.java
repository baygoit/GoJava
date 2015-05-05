package com.sergiisavin.kickstarter;

public interface Categories {

	public abstract void add(String categoryName);

	public abstract void add(Category category);

	public abstract Category get(int i);

	public abstract int getSize();

	public abstract String toString();

	public class IllegalArgumentException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}

}