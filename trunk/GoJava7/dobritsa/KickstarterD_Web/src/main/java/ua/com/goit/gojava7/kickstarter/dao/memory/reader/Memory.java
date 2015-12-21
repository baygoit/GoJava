package ua.com.goit.gojava7.kickstarter.dao.memory.reader;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;
import ua.com.goit.gojava7.kickstarter.models.Quote;
import ua.com.goit.gojava7.kickstarter.models.Reward;

public class Memory {

	private List<Quote> quotes = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<Reward> rewards = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();

	public Memory() {
		initQuotes();

		initCategories();

		initProjects();

		initQuestions();

		initRewards();
	}

	private void initQuotes() {
		Quote quote;

		quote = new Quote();
		quote.setText("There is only one boss. The customer. And he can fire everybody in the company "
				+ "from the chairman on down, simply by  spending his money somewhere else.");
		quote.setAuthor("Sam Walton");
		quotes.add(quote);

		quote = new Quote();
		quote.setText("Ideas pull the trigger, but instinct loads the gun.");
		quote.setAuthor("Don Marquis");
		quotes.add(quote);

		quote = new Quote();
		quote.setText("There are no secrets to success. It is the result of preparation, "
				+ "hard work, and learning from failure.");
		quote.setAuthor("Colin Powell");
		quotes.add(quote);

		quote = new Quote();
		quote.setText("Happiness does not come from doing easy work but from the afterglow "
				+ "of satisfaction that comes after the achievement of a difficult task that demanded our best.");
		quote.setAuthor("Theodore Isaac Rubin");
		quotes.add(quote);
	}

	private void initCategories() {
		Category category;

		category = new Category();
		category.setName("Music");
		categories.add(category);

		category = new Category();
		category.setName("Food");
		categories.add(category);

		category = new Category();
		category.setName("Dances");
		categories.add(category);
	}

	private void initProjects() {
		Project project;

		project = new Project();
		project.setName("Shift the Grid presents Vacancy");
		project.setDescription("Vacancy: A contemporary dance performance produced collaboratively "
				+ "by 6 minds exploring what it feels like to be in two places at once. ");
		project.setGoal(21000);
		project.setPledged(2100);
		project.setDaysToGo(21);
		project.setHistory("So we embarked on the impossible. Collaborating with the usual "
				+ "six minds in the room, and bringing in three more to the mix, "
				+ "over the past six months. Shift the Grid is coming up on it's "
				+ "year anniversary and has been selected as the resident artist "
				+ "for Motion Pacific's Incubator project. We are honored and "
				+ "lucky to have the opportunity as an incredibly young collective, "
				+ "to embark on the journey of putting on our own evening lengths "
				+ "work. We are so EXCITED!! And nervous, and unsure and "
				+ "completely making things up as we go along. The aim of "
				+ "the project is to explore our curiosities through contemporary "
				+ "dance, and work in a truly collaborative process in doing so. "
				+ "We wanted to push ourselves to make the entirety of our show "
				+ "together as 6 choreographers, honoring each voice and body in the room. ");
		project.setLink("https://d2pq0u4uni88oo.cloudfront.net/projects/2153340/video-600743-h264_high.mp4");
		project.setCategoryName("Dances");
		projects.add(project);

		project = new Project();
		project.setName("DanceProject2");
		project.setDescription("Description22");
		project.setGoal(22000);
		project.setPledged(2200);
		project.setDaysToGo(22);
		project.setHistory("history22");
		project.setLink("link22");
		project.setCategoryName("Dances");
		projects.add(project);

		project = new Project();
		project.setName("DanceProject3");
		project.setDescription("Description23");
		project.setGoal(23000);
		project.setPledged(2300);
		project.setDaysToGo(23);
		project.setHistory("history22");
		project.setLink("link22");
		project.setCategoryName("Dances");
		projects.add(project);

		project = new Project();
		project.setName("'Critical Mass': New solo music from Jerry Chamberlain!");
		project.setDescription("You can help Jerry Chamberlain (Daniel Amos, Swirling Eddies, "
				+ "Boy-O-Boy, Pamelita & Parker) record his first solo album! ");
		project.setGoal(20000);
		project.setPledged(3903);
		project.setDaysToGo(23);
		project.setHistory("Forty years ago in 1975, Jerry Chamberlain walked into a "
				+ "professional recording studio for the first time to lay down "
				+ "his initial recorded work as a founding member with Daniel "
				+ "Amos (DA). Since that time, he has played guitar and sung on "
				+ "many artists� projects, some of those his own (Boy-O-Boy, "
				+ "The Balls Of France), and lent musical support for many "
				+ "recordings. Besides Daniel Amos, Chamberlain has been a "
				+ "long-time member of Swirling Eddies (under the pseudonym of "
				+ "�Spot�). His own songs have surfaced here and there (�Man In "
				+ "The Moon�, �Little Crosses�, etc.), but he has never recorded "
				+ "a solo album. Until now. Announcing the eclectic rock debut "
				+ "from lead guitarist-singer/songwriter/producer, Jerry "
				+ "Chamberlain. We have reached Critical Mass.");
		project.setLink("https://d2pq0u4uni88oo.cloudfront.net/projects/2150887/video-600235-h264_high.mp4");
		project.setCategoryName("Music");
		projects.add(project);

		project = new Project();
		project.setName("MusicProject2");
		project.setDescription("Description12");
		project.setGoal(12000);
		project.setPledged(1200);
		project.setDaysToGo(12);
		project.setHistory("history12");
		project.setLink("link12");
		project.setCategoryName("Music");
		projects.add(project);

		project = new Project();
		project.setName("MusicProject3");
		project.setDescription("Description13");
		project.setGoal(13000);
		project.setPledged(1300);
		project.setDaysToGo(13);
		project.setHistory("history13");
		project.setLink("link13");
		project.setCategoryName("Music");
		projects.add(project);

		project = new Project();
		project.setName("The Cookie Counter: vegan bakery, espresso bar, & ice cream!");
		project.setDescription("Seattle's first 100% plant based ice cream truck is ready for a shop "
				+ "of its own! Serving organic treats & espresso, all made with love.");
		project.setGoal(31000);
		project.setPledged(3100);
		project.setDaysToGo(31);
		project.setHistory("Add any of the amounts listed below to any LOCAL pledge level and "
				+ "you will get pints of our EXCLUSIVE Kickstarter flavor! Didn't "
				+ "back the Kickstarter and do an add-on? Sorry! This is gonna "
				+ "be an insanely yummy flavor, so don't miss out! If you like it "
				+ "a whole lot, we'll add it to our permanent rotation at a later "
				+ "date AND you get to vote on the name!");
		project.setLink("There is no video");
		project.setCategoryName("Food");
		projects.add(project);

		project = new Project();
		project.setName("FoodProject2");
		project.setDescription("Description12");
		project.setGoal(12000);
		project.setPledged(1200);
		project.setDaysToGo(12);
		project.setHistory("history12");
		project.setLink("link12");
		project.setCategoryName("Food");
		projects.add(project);

		project = new Project();
		project.setName("FoodProject3");
		project.setDescription("Description13");
		project.setGoal(13000);
		project.setPledged(1300);
		project.setDaysToGo(13);
		project.setHistory("history13");
		project.setLink("link13");
		project.setCategoryName("Food");
		projects.add(project);
	}

	private void initQuestions() {
		Question question;

		question = new Question();
		question.setQuestion("some question 1");
		question.setProjectName("The Cookie Counter: vegan bakery, espresso bar, & ice cream!");
		questions.add(question);

		question = new Question();
		question.setQuestion("some question 2");
		question.setProjectName("'Critical Mass': New solo music from Jerry Chamberlain!");
		questions.add(question);

		question = new Question();
		question.setQuestion("some question 3");
		question.setProjectName("Shift the Grid presents Vacancy");
		questions.add(question);
	}

	private void initRewards() {
		Reward reward;

		reward = new Reward();
		reward.setAmount(2);
		reward.setReward("2 bonuses");	
		reward.setProjectName("The Cookie Counter: vegan bakery, espresso bar, & ice cream!");
		rewards.add(reward);
		
		reward = new Reward();
		reward.setAmount(5);
		reward.setReward("5 bonuses");	
		reward.setProjectName("'Critical Mass': New solo music from Jerry Chamberlain!");
		rewards.add(reward);
		
		reward = new Reward();
		reward.setAmount(7);
		reward.setReward("7 bonuses");	
		reward.setProjectName("Shift the Grid presents Vacancy");	
		rewards.add(reward);
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Reward> getRewards() {
		return rewards;

	}

}
