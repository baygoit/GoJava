package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;

public class Store {

	GoodsStorage storage;	
	
	PrintStream outStream;
	
	public Store (PrintStream outStreamArg ){
		storage = new GoodsStorage (System.out);
	}
	
	
}




