package ua.com.goit.gojava2.vova.kickstarter.util;

public class Random {

	public static int random(int countQuote) {
		return (int) (Math.random() * (countQuote) + 1);
	}
}
