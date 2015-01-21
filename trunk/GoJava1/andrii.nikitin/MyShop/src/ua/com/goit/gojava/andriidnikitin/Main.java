package ua.com.goit.gojava.andriidnikitin;

public class Main {
	
	public static void main(String[] args){		
		Store myStore = new Store(System.out);
		System.out.println("Categories:");
		myStore.showCategories();
		System.out.println("Goods in 3 category:");
		myStore.showGoodsInCategory(3);	
		System.out.println("Goods in 2 category:");
		myStore.showGoodsInCategory(2);	
		System.out.println("Goods in 3 category:");
		myStore.showGoodsInCategory(1);		
	}
}