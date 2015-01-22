package ua.com.goit.gojava.andriidnikitin;

import java.io.PrintStream;
import java.util.List;

public class Main {
	
	public static void main(String[] args){		
		GoodStorageInMemory myStore = new GoodStorageInMemory();
		System.out.println("Categories:");
		printListWithNumeration(myStore.getCategoryList(), System.out);
		System.out.println("Goods in 3 category:");		
		printGoodsInCategory(myStore, System.out, 3 );
		System.out.println("Goods in 2 category:");
		printGoodsInCategory(myStore, System.out, 2 );
		System.out.println("Goods in 1 category:");
		printGoodsInCategory(myStore, System.out, 1 );
	}
	
	private static <T> void printListWithNumeration (List<T> list, 
			PrintStream outStream){
		if (list == null) return; 
		for (int i = 0; i < list.size(); i++)
			outStream.println(i + 1 + " - " + list.get(i));
		outStream.println();
	}
	
	private static void printGoodsInCategory(GoodStorageInMemory myStore, 
			PrintStream outStream, int numberOfCategory ){
	//	printListWithNumeration(myStore.getGoodList(myStore.getCategory(numberOfCategory - 1)) ,outStream);
	}
	
}