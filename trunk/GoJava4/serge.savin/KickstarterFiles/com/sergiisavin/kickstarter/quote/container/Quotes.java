package com.sergiisavin.kickstarter.quote.container;

import javax.naming.OperationNotSupportedException;

public interface Quotes {


	public abstract int getSize();

	public abstract void add(String quote) throws OperationNotSupportedException;

	public abstract String getRandomQuote();

	public abstract void delete(int index) throws OperationNotSupportedException;

	public abstract String get(int i);

	public class IllegalArgumentException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
	}

}