import java.util.HashMap;
import java.util.Map;

public class DanceCategory {
	private Map<Integer, Project> secondCategory = new HashMap<>();
	{ 
		secondCategory.put(1, new Project(
				"Shift the Grid presents Vacancy", 
				"Vacancy: A contemporary dance performance produced collaboratively "
				+ "\n     by 6 minds exploring what it feels like to be in two places at once. ", 
				21000, 2100, 21, 
				"So we embarked on the impossible. Collaborating with the usual "
				+ "\n     six minds in the room, and bringing in three more to the mix, "
				+ "\n     over the past six months. Shift the Grid is coming up on it’s "
				+ "\n     year anniversary and has been selected as the resident artist "
				+ "\n     for Motion Pacific’s Incubator project. We are honored and "
				+ "\n     lucky to have the opportunity as an incredibly young collective, "
				+ "\n     to embark on the journey of putting on our own evening lengths "
				+ "\n     work. We are so EXCITED!! And nervous, and unsure and "
				+ "\n     completely making things up as we go along. The aim of "
				+ "\n     the project is to explore our curiosities through contemporary "
				+ "\n     dance, and work in a truly collaborative process in doing so. "
				+ "\n     We wanted to push ourselves to make the entirety of our show "
				+ "\n     together as 6 choreographers, honoring each voice and "
				+ "\n     body in the room. ", 
				"https://d2pq0u4uni88oo.cloudfront.net/projects/2153340/video-600743-h264_high.mp4", 
				"No questions at the moment"));
	
		secondCategory.put(2, new Project("Name22", "Description22", 22000, 2200, 22, "history22", "link22", "questions22"));
	
		secondCategory.put(3, new Project("Name23", "Description23", 23000, 2300, 23, "history22", "link22", "questions22"));
	}
	
	public Map<Integer, Project> getProjects() {		
		return secondCategory;		
	}
	
}
