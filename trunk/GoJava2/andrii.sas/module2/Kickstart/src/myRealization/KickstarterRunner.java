package myRealization;

import java.util.Random;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		new Storage(new ConsoleOutput(), new ConsoleInput(), new QuoteGenerator(new Random())).initiate();
	}
}