package com.go_java4.alex_mirn.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Quote {
	private String quote;

	public Quote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return quote;
	}

}