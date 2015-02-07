package mainkick;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Categories {
	private ArrayList<Category> listCatecories = new ArrayList<Category>();
	private int counterCategory;
	
	public String readAllCatecories() throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		ArrayList<String[]> categoryBD = reader.read("Categories.properties");
    	int i = 0;
		String s = "";
		Category category = new Category();
		for (String[] value : categoryBD) {
			getListCatecories().add(new Category());
		    s += category.readCatecory(getListCatecories(), i, value);
		    i++;
		}
		setCounterCategory(getListCatecories().size());
		return s.substring(0, s.length() - 1);
	}

	public int getCounterCategory() {
		return counterCategory;
	}

	public void setCounterCategory(int counterCategory) {
		this.counterCategory = counterCategory;
	}

	public ArrayList<Category> getListCatecories() {
		return listCatecories;
	}

	public void setListCatecories(ArrayList<Category> listCatecories) {
		this.listCatecories = listCatecories;
	}

}
