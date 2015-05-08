package Kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Quotes {
	private String quote;
	
	public Quotes(String quote) {
		this.quote = quote;
	}
	
	@Override
	public String toString() {
		return quote;
	}

}