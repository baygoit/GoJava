package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;

public class Store {

	private GoodStorageInMemory storage;	
	
	private PrintStream outStream;
	
	public Store (PrintStream outStreamArg ){
		storage = new GoodStorageInMemory (outStreamArg);
	}
	
	public void showCategories(){
	}
	
	public void showGoodsInCategory(int categoryID){
		storage.showGoodsInCategory(categoryID);
	}
}




