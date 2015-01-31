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
			
			JSONObject jsonObject1 = (JSONObject) a.get(0);
			JSONObject jsonObject2 = (JSONObject) a.get(1);
			JSONObject jsonObject3 = (JSONObject) a.get(2);
			JSONObject jsonObject4 = (JSONObject) a.get(3);
			JSONObject jsonObject5 = (JSONObject) a.get(4);
			JSONObject jsonObject6 = (JSONObject) a.get(5);

			Project project1 = new Project("" + jsonObject1.get("name"), "" + jsonObject1.get("description"),
					Integer.parseInt("" + jsonObject1.get("goal")), Integer.parseInt("" + jsonObject1.get("daysLeft")),
					"" + jsonObject1.get("history"), "" + jsonObject1.get("linksToVideo"));
			Project project2 = new Project("" + jsonObject2.get("name"), "" + jsonObject2.get("description"),
					Integer.parseInt("" + jsonObject2.get("goal")), Integer.parseInt("" + jsonObject2.get("daysLeft")),
					"" + jsonObject2.get("history"), "" + jsonObject2.get("linksToVideo"));
			Project project3 = new Project("" + jsonObject3.get("name"), "" + jsonObject3.get("description"),
					Integer.parseInt("" + jsonObject3.get("goal")), Integer.parseInt("" + jsonObject3.get("daysLeft")),
					"" + jsonObject3.get("history"), "" + jsonObject3.get("linksToVideo"));
			Project project4 = new Project("" + jsonObject4.get("name"), "" + jsonObject4.get("description"),
					Integer.parseInt("" + jsonObject4.get("goal")), Integer.parseInt("" + jsonObject4.get("daysLeft")),

					"" + jsonObject4.get("history"), "" + jsonObject4.get("linksToVideo"));
			Project project5 = new Project("" + jsonObject5.get("name"), "" + jsonObject5.get("description"),
					Integer.parseInt("" + jsonObject5.get("goal")), Integer.parseInt("" + jsonObject5.get("daysLeft")),
					"" + jsonObject5.get("history"), "" + jsonObject5.get("linksToVideo"));
			Project project6 = new Project("" + jsonObject6.get("name"), "" + jsonObject6.get("description"),
					Integer.parseInt("" + jsonObject6.get("goal")), Integer.parseInt("" + jsonObject6.get("daysLeft")),
					"" + jsonObject6.get("history"), "" + jsonObject6.get("linksToVideo"));

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
