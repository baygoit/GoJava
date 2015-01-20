package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;

public class Store {

	private GoodsStorage storage;	
	
	private PrintStream outStream;
	
	public Store (PrintStream outStreamArg ){
		storage = new GoodsStorage (outStreamArg);
	}
	
	public void showCategories(){
		storage.showCategories();
	}
	
	public void showGoodsInCategory(int categoryID){
		storage.showGoodsInCategory(categoryID);
	}
}




