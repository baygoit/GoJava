package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Categories {
	static ArrayList<Category> listCatecories = new ArrayList<Category>();
	static int counterCategory;
	
	public String readAllCatecories() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> categoryBD = reader.read("Categories.properties");
    	int i = 0;
		String s = "";
		Category category = new Category();
		for (String[] value : categoryBD) {
			listCatecories.add(new Category());
		    s += category.readCatecory(categoryBD, listCatecories, i, value);
		    i++;
		}
		counterCategory = listCatecories.size();
		return s.substring(0, s.length() - 1);
	}

}
