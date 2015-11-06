package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;

	/**
	 * create class Category which contain list categories
	 * 
	 */
public class Categorie {

	protected static List<String> listCategoies = new ArrayList<>();

	{
		listCategoies.add("Photo");
		listCategoies.add("Movie");
		listCategoies.add("Record");
	}
	
	public String getCategoie(Integer indexCategorie) {
		return listCategoies.get(indexCategorie);
	}

}
