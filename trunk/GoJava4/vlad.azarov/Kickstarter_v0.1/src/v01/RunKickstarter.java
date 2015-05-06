package v01;
import java.util.Scanner;


public class RunKickstarter {
	
	public static void main(String[] args) {
		
		Quote[] creatingQuotes = new Quote[] {
				new Quote("Start by doing what's necessary; then do what's possible; and suddenly you are doing the impossible", "(© Unknown author)"),
				new Quote("Perfection is not attainable, but if we chase perfection we can catch excellence", "(© Unknown author)"),
				new Quote("Stay hungry, stay foolish.", "(© Steve Jobs)"),
				new Quote("My favorite things in life don't cost any money. It's really clear that the most precious"
						+ "resource we all have is time", "(© Steve Jobs)"),
				new Quote("You have to learn the rules of the game. And then you have to play better than anyone else", 
						"(© Unknown author)"),
		};
		
		Category[] creatingCategories = new Category[] {
				new Category("Design"),
				new Category("Games"),
				new Category("Music"),
				new Category("Technology")
		};
		
		Project[] designCategory = new Project[] {
				new Project("Tribe UltraLight",
						"The wallet of the future",
						10000, 24600, 5,
						"Lighter, tighter, and easier than any minimalist wallet."
						+ " Made from aerospace grade carbon fiber, texalium, and titanium.",
						"https://www.youtube.com/watch?v=707thRcJkRI",
						"Have a question?",
						"If the info above doesn't help, you can ask the project creator directly." ),
				
				new Project("Flyte",
						"Levitating Light",
						80000, 459066, 15,
						"Flyte is a levitating lightbulb powered through the air.",
						"https://www.youtube.com/watch?v=CMG7x_2CjHI",
						"Will I need to replace the bulb?",
						"No. We use energy-efficient LEDs rated at 50 000 hours or the equivalent of 12 hours a day for 11 years." )
		};
		
		Project[] gamesCategory = new Project[] {
				new Project("Space Dust Racers",
						"Crazy space race",
						128000, 16067, 22,
						"Intergalactic party racing mayhem featuring brutal-cute aliens,"
						+ "absurd weapon powerups, and smartphone controllers for up to 16 players",
						"https://www.youtube.com/watch?v=2EetzSz7jck&feature=youtu.be",
						"How much will the final game cost?",
						"We haven’t locked it down yet, but there shouldn’t be any nasty surprises."
						+ "We need to talk with our platform partners once the Kickstarter campaign"
						+ "has ended and we’re greenlit on Steam." ),
				
				new Project("F**k. The Game",
						"A new card game to swear at your friends while becoming smarter in the process",
						7000, 12334, 24,
						"F**k. The Game is a new card game for ages 18+ that combines science and swearing"
						+ "to create a fun and unique new game.",
						"https://youtu.be/MOLCWZgmwm4",
						"Have a question?",
						"If the info above doesn't help, you can ask the project creator directly." ),
		};
		
		Project[] musicCategory = new Project[] {
				new Project("Daryl Shawn",
						"ON TIME | international fingerstyle guitar",
						5000, 4485, 22,
						"The first professionally-produced album from this widely-touring, globally-influenced guitarist.",
						"https://www.youtube.com/user/darylshawn",
						"Have a question?",
						"If the info above doesn't help, you can ask the project creator directly." ),
		};
		
		System.out.println("Welcome to KICKSTARTER v0.1");
		
				
		

		
	}
}







