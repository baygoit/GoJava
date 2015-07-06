package belskii.artem.kickstarter;

import java.util.ArrayList;

public class CategoryView {
	
	public void printCategoryList(ArrayList<String> catList){
		for (int i = 0; i<catList.size(); i++){
			System.out.println(catList.get(i));
		}
	}
	
}
