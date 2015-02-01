package mainkick;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Categories {
	private Map<Integer, String[]> categoryBD;
	{
	    try {
	    	ReaderBD reader = new ReaderBD();
	    	categoryBD = reader.read("Categories.properties");
	    }
	    catch (IOException e) {
	       throw new RuntimeException(e);
	    }
	}

	public int counterCategory = categoryBD.size();
	public static ArrayList<Category> listCatecories = new ArrayList<Category>();
	
	public void showAllCatecories() throws FileNotFoundException{
		Output out = new OutputConsole();
		int i = 0;
		for (String[] value : categoryBD.values()) {
			listCatecories.add(new Category());
			listCatecories.get(i).categoryID = Integer.valueOf(value[0]);
			listCatecories.get(i).categoryName = value[1];
			String[] string = value[2].split(",");
			listCatecories.get(i).projectsThatContain = new int[string.length];
			for (int j = 0; j < string.length; j++){
				listCatecories.get(i).projectsThatContain[j] = Integer.valueOf(string[j]);
			}
		    out.print(listCatecories.get(i).categoryID + " " + listCatecories.get(i).categoryName);
		    i++;
		}
	}
	
}
