import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {
	
	private List<String> quotes;
	private List<Сategory> categories;
	
	private List<Project> projectsFood;
	private List<Project> projectsMusic;
	private List<Project> projectsEducation;
	
	private Map<Сategory, List<Project>> map;
	
	public DataStorage() {
		initQuotes();
		initCategories();
		initProjects();
		initMap();
	}
	
	private void initQuotes() {
		quotes = new ArrayList<String>();
		quotes.add("\"Lost time is never found again.\"");
		quotes.add("\"The future belongs to those, who believe of their dreams.\"");
		quotes.add("\"If you never try you'll never know.\"");
		quotes.add("\"The only way to do great work, is to love what you do.\"");
		quotes.add("\"Every thing is easy, when you are crazy and nothing is easy when you are lazy.\"");
		quotes.add("\"An investment in knowledge always pays the best interest.\"");
		quotes.add("\"It does not matter how slowly you go so long as you do not stop.\"");
		quotes.add("\"Money spent on the brain, is never spent in vain.\"");
	}

	private void initCategories() {
		categories = new ArrayList<Сategory>();
		categories.add(new Сategory("Food"));
		categories.add(new Сategory("Music"));
		categories.add(new Сategory("Education"));
	}
	
	private void initProjects() {
		projectsFood = new ArrayList<Project>();
		projectsMusic = new ArrayList<Project>();
		projectsEducation = new ArrayList<Project>();
		
		projectsFood.add(new Project("1.Green Pea Cookie. ", "We want to produce green cookies. ",
				"Coming soon... ","http:gps.rom.new", 8000, 3654, 17));
		projectsFood.add(new Project("2.House wine. ", "We make delicious homemade wine. ",
				"Coming soon... ", "http:hw.est.new",14000, 9006, 20));
		projectsFood.add(new Project("3.CookBook. ", "We have collected recipes 2000 and we want"
				 + " to release a book. ","Coming soon. . ", "http:cb.gri.new",12000, 2700, 28));
		projectsMusic.add(new Project("1.Musical Instruments. ", "Help for beginners. ",
				"Coming soon...  ","http:mi.beg.new ",25000, 12908, 48));
		projectsEducation.add(new Project("1.English Speaking Club Online. ", "Сommunication with "
				+ "native speakers via internet. ", "Coming soon. .  ", "http:esco.com.new", 30000, 20124, 9));
		projectsEducation.add(new Project("2.Martial Arts. ", "Study of martial arts. ",
				"Coming soon...  ", "http:ma.st.new", 48000, 5798, 56));
	}
	
	public String getRundomQuote() {
		int i = (int)(Math.random() * quotes.size());
		return quotes.get(i);
	}
	
	public void initMap() {
		  map = new HashMap<Сategory, List<Project>>();
		  map.put(categories.get(0), projectsFood);
		  map.put(categories.get(1), projectsMusic);
		  map.put(categories.get(2), projectsEducation);
	}
	
	public List<Сategory> getCategoriesList() {
		return categories;
	}

   public List<Project> getSpecificProject(Сategory сategory) {
	   return map.get(сategory);
   }
}