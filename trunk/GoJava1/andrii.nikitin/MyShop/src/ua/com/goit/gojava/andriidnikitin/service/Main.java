package ua.com.goit.gojava.andriidnikitin.service;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class Main {

	public static void main(String[] args) throws ShopException  {
		/*
		StorageFlat store = new StorageFlat();
		List<Good> goods = store.getGoodList();
		for (Good good: goods){
			System.out.println(good.printInfo());
		}*/
		StorageXmlNew store = new StorageXmlNew();
		for(Category category: store.getCategoryList()){
			for(Good good : store.getGoodList(category)){
				System.out.println(good);
			}
			System.out.println();
		}
	}
	
	/*
		DataBuilder instance = new DataBuilder();
		Warehouse warehouse = new Warehouse();
		warehouse.init();
		instance.marshall(warehouse, new File("resources/DataFile.xml"));
		warehouse = instance.unmarshall(new File("resources/DataFile.xml"));
		printWarehouse(warehouse, System.out);		
		System.out.println("Done");
	}
	
	private static void printWarehouse(Warehouse warehouse, PrintStream stream) {/*
		StorageImpl store = new StorageImpl();
		store.setCategoryList(warehouse.getCategoryList());
		store.setGoodList(warehouse.getGoodList());
		List<Category> list = store.getCategoryList();
		for (int i = 0; i < list.size(); i++){
			stream.println(list.get(i).printInfo());
			List<Good> goodList = store.getGoodList(list.get(i));
			for (int i1 = 0; i1 < goodList.size(); i1++){
				stream.println("  " + goodList.get(i1).printInfo());
			}
		}
		
		
		StorageXML store = new StorageXML();
		List<Category> list = store.getCategoryList();
		for (int i = 0; i < list.size(); i++){
			stream.println(list.get(i).printInfo());
		}	
		store.init();
		List<Category> list2 = store.getCategoryList();
		for (int i = 0; i < list.size(); i++){
			stream.println(list.get(i).printInfo());
		}	
	}
*/
	
}