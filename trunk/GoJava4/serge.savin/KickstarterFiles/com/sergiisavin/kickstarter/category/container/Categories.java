package com.sergiisavin.kickstarter.category.container;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.category.Category;

public interface Categories {

	public abstract void add(String categoryName) throws OperationNotSupportedException;

	public abstract void add(Category category) throws OperationNotSupportedException;

	public abstract Category get(int i);

	public abstract int getSize();

	public abstract String toString();

	public class IllegalArgumentException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}

}