package ua.home.kickstarter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManager {

	public void dataInputToobjects() {
		JSONParser parser = new JSONParser();
		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("d:\\ss12.json"));

			Category category1 = new Category("Games");
			Category category2 = new Category("Technology");
			Category category3 = new Category("Design");

			Categories categories = new Categories();

			categories.add(category1);
			categories.add(category2);
			categories.add(category3);

			Project project1 = new Project((JSONObject) a.get(0));
			Project project2 = new Project((JSONObject) a.get(1));
			Project project3 = new Project((JSONObject) a.get(2));
			Project project4 = new Project((JSONObject) a.get(3));
			Project project5 = new Project((JSONObject) a.get(4));
			Project project6 = new Project((JSONObject) a.get(5));
			project1.setCategory(category1);
			project2.setCategory(category1);
			project3.setCategory(category1);
			project4.setCategory(category2);
			project5.setCategory(category2);
			project6.setCategory(category2);

			Projects projects = new Projects();
			projects.add(project1);
			projects.add(project2);
			projects.add(project3);
			projects.add(project4);
			projects.add(project5);
			projects.add(project6);

			Processor processor = new Processor(categories, projects);
			processor.run();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
