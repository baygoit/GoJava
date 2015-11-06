import java.util.HashMap;
import java.util.Map;

public class ThirdCategory {
	private Map<Integer, Project> thirdProjects = new HashMap<>();
	{ 
		thirdProjects.put(1, new Project(
			"The Cookie Counter: vegan bakery, espresso bar, & ice cream!", 
			"Seattle's first 100% plant based ice cream truck is ready for a shop "
			+ "of its own! Serving organic treats & espresso, all made with love.", 
			31000, 3100, 31, 
			"Add any of the amounts listed below to any LOCAL pledge level and "
			+ "you will get pints of our EXCLUSIVE Kickstarter flavor! Didn't "
			+ "back the Kickstarter and do an add-on? Sorry! This is gonna "
			+ "be an insanely yummy flavor, so don't miss out! If you like it "
			+ "a whole lot, we'll add it to our permanent rotation at a later "
			+ "date AND you get to vote on the name!", 
			"There is no video", 
			"No questions at the moment"));
	
		thirdProjects.put(2, new Project("Name32", "Description32", 32000, 3200, 32, "history32", "link32", "questions32"));
	
		thirdProjects.put(3, new Project("Name33", "Description33", 33000, 3300, 33, "history33", "link33", "questions33"));
	}
	
	Map<Integer, Project> getProjects() {		
		return thirdProjects;		
	}	
}
