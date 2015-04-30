package kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Kickstarter {
	//Category a;
	public void start(ArrayList<Category>listCategories) {
		for(Category i:listCategories){
			System.out.println(i.id+"-"+i.name);
		}
	}

}
