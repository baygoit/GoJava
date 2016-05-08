package kickstarter;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import kickstarter.domain.Project;
import kickstarter.manager.Manager;

public class App {

	public static void main(String[] args) {

		Manager m = new Manager();
/**
		System.out.println(m.getRandomQuote());

		List<String> categories = m.getAllCategories();
		for (String category : categories) {
			System.out.println(category);
		}
*/
		HashMap<Integer, String> projects = m.getAllProjectsByCategory("tango");
		for (Entry<Integer, String> project : projects.entrySet()) {
			System.out.println(project.getKey()+" = "+project.getValue());
		}

		List<String> project = m.openProject(3);
		for (String info : project) {
			System.out.println(info);
			/**
			 * m.sponsor(3, 11); m.addCommentTo(3, "Kate", "Love it=)");
			 * project=m.openProject(3); for(String info:project){
			 * System.out.println(info); }
			 * 
			 * }
			 */
		}
	}
}
