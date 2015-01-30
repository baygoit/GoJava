package ua.com.goit.gojava.andriidnikitin;
/*
import java.io.PrintStream;
import java.util.List;
*/
public class Main {/*
	public static void main(String[] args){		
		GoodStorageImpl myStore = new GoodStorageImpl();
		System.out.println("Categories:");
		List<Category> categoryList = myStore.getCategoryList();
		printListWithNumeration(myStore.getCategoryList(), System.out);
		System.out.println("Goods in 3 category:");		
		printCategory(myStore, categoryList.get(2), System.out);
		System.out.println("Goods in 2 category:");
		printCategory(myStore,  categoryList.get(1), System.out);
		System.out.println("Goods in 1 category:");
		printCategory(myStore, categoryList.get(0), System.out);
	}
	
	private static <T> void printListWithNumeration (List<T> list, 
			PrintStream outStream){
		if (list == null) return; 
		for (int i = 0; i < list.size(); i++)
			outStream.println(i + 1 + " - " + list.get(i));
		outStream.println();
	}
	
	private static void printCategory(GoodStorageImpl myStore, 
			Category category, PrintStream stream){ 
		try {
			printListWithNumeration(myStore.getGoodList(category), stream);			
		}
		catch (NullPointerException exception){
			stream.println("Not found!");
		}	
	}*/	
}