package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManager {
	private Categories categories;
	private Projects projects;
	private List<Project> project;

	public void storage() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("d:\\Projects.json"));

			categories = new Categories();

			categories.add(new Category("Games"));
			categories.add(new Category("Technology"));
			categories.add(new Category("Design"));
			
			project = new ArrayList<Project>();
			for (int i = 0; i < a.size(); i++) {
				project.add(new Project((JSONObject) a.get(i)));
			}
//			project.get(0).setCategory(categories.getCategories().get(1));
//			project.get(1).setCategory(categories.getCategories().get(1));
//			project.get(2).setCategory(categories.getCategories().get(1));
//			project.get(3).setCategory(categories.getCategories().get(2));
//			project.get(4).setCategory(categories.getCategories().get(2));
//			project.get(5).setCategory(categories.getCategories().get(2));

			for (int i = 0; i < a.size(); i++) {
				if(i < 3){
				project.get(i).setCategory(categories.getCategories().get(1));
				}else if (i >= 3) {
				project.get(i).setCategory(categories.getCategories().get(2));	
				}
			}
			
			projects = new Projects();
			for (int i = 0; i < a.size(); i++) {
				projects.add(project.get(i));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Categories getCategories() {
		return categories;
	}

	public Projects getProjects() {
		return projects;
	}
}
