package kickstarter_gk;

import java.util.ArrayList;

public class Categories {
    int idCat;
	private ArrayList<Category> allCategories = new ArrayList<Category>();
	
	//public Categories () {
		
	//}
	
	public void initCategory () {
		// метод первоначального заполнения таблицы с категориями.
		allCategories.add(new Category(0, "Sport",0));
		allCategories.add(new Category(1, "Cinema",0));
		allCategories.add(new Category(2, "HighTech",0));
		allCategories.add(new Category(3, "Science",0));
		allCategories.add(new Category(4, "Health",0));
		idCat = 4;
	};

	public void addCategory (String category) {
		// здесь надо перестроить под работу со Storage
		// TODO проверить, есть ли такая категория
		
       //TODO вернуть idCat последней существующей категории, чтобы его использовать
	   
	   allCategories.add(new Category(idCat, category,0));
	   
	   idCat++;
		}
	
	
	
	public Category getCategories(int cat) {
	
		Category nameCategory = allCategories.get(cat);
		
		return	nameCategory;
	}
	
}
