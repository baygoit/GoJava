package ua.com.goit.gojava7.kickstarter;
import java.util.HashMap;
import java.util.Map;

// OLEG what will be our work if the list of categories can be changed?
public class MusicCategory {

	private Map<Integer, Project> firstCategory = new HashMap<>();
	{
		firstCategory.put(1, new Project(
				"'Critical Mass': New solo music from Jerry Chamberlain!", 
				"You can help Jerry Chamberlain (Daniel Amos, Swirling Eddies, "
				+ "\n     Boy-O-Boy, Pamelita & Parker) record his first solo album! ", 
				20000, 3903, 23, 
				"Forty years ago in 1975, Jerry Chamberlain walked into a "
				+ "\n     professional recording studio for the first time to lay down "
				+ "\n     his initial recorded work as a founding member with Daniel "
				+ "\n     Amos (DA). Since that time, he has played guitar and sung on "
				+ "\n     many artists’ projects, some of those his own (Boy-O-Boy, "
				+ "\n     The Balls Of France), and lent musical support for many "
				+ "\n     recordings. Besides Daniel Amos, Chamberlain has been a "
				+ "\n     long-time member of Swirling Eddies (under the pseudonym of "
				+ "\n     “Spot”). His own songs have surfaced here and there (“Man In "
				+ "\n     The Moon”, “Little Crosses”, etc.), but he has never recorded "
				+ "\n     a solo album. Until now. Announcing the eclectic rock debut "
				+ "\n     from lead guitarist-singer/songwriter/producer, Jerry "
				+ "\n     Chamberlain. We have reached Critical Mass.", 
				"https://d2pq0u4uni88oo.cloudfront.net/projects/2150887/video-600235-h264_high.mp4", 
				"No questions at the moment"));
	
		firstCategory.put(2, new Project("Name12", "Description12", 12000, 1200, 12, "history12", "link12", "questions12"));
	
		firstCategory.put(3, new Project("Name13", "Description13", 13000, 1300, 13, "history13", "link13", "questions13"));
	}
	
	//TODO
	// OLEG why we return inner map as is?
	public Map<Integer, Project> getProjects() {		
		return firstCategory;		
	}
	
}
