package ua.goit.goitjava.kickstarter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		Category cat1 = new Category("Education");
		Category cat2 = new Category("Finance");
		Category cat3 = new Category("Game");
		
		
		Categories cats1 = new Categories();
		cats1.addCategory(cat1);
		cats1.addCategory(cat2);
		cats1.addCategory(cat3);
		
		for(Category c: cats1.getCategory()){
			System.out.println(c.getName());
		}
		

	}

}
