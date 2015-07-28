package belskii.artem.kickstarter;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.category.Category;
import belskii.artem.kickstarter.dao.project.Project;

public class Output {
	
	public void show(String line){
		System.out.println(line);
	}
	
	public void show (ArrayList<Category> list){
		for (int i = 0; i<list.size(); i++){
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(list.get(i).getCategoryId());
			strBuilder.append(": ");
			strBuilder.append(list.get(i).getCategoryName());
			System.out.println(strBuilder.toString());
		}
		System.out.println("Please select category number, and press Enter:");
	}



}
