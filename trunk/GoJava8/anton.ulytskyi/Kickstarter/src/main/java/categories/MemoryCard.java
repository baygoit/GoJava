package categories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MemoryCard {
	
	public final static String MEMORY_SWITHER = "memory card: on";
	public static boolean switcher; 
	
Category kickstarter = new Category();	
	
	public Category loadBase() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("source/MemoryCardSettings.txt"))) {
			String memorySetting = "";
			for (; (memorySetting = br.readLine()) != null;) {
				
				if(memorySetting.equals(MEMORY_SWITHER)){
					loadBaseFromFile();
					switcher = true;
				} else {
					loadBaseFromTemporarilySolution();
				}
			}
		} catch (IOException e) {
			loadBaseFromTemporarilySolution();
			return kickstarter;
		}
		
		return kickstarter;
	}

	private void loadBaseFromFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("source/MemoryCard.txt"))) {
			
			String information = "";
			for (; (information = br.readLine()) != null;) {
				if (information.equals("")){
					break;
				}
				translate(information);
		
			}
		} catch (IOException e) {
			
		}
		
	
	}

	private void translate(String information) {
		
		String field []=information.split("\\|");
		
		int id = Integer.parseInt(field[0]);
		
		kickstarter.category.add(new Project(id, field[1], field[2], field[3], Integer.parseInt(field[4]),
				translateDate(field[6]),
				field[8],
				field[9]));
		
		kickstarter.saveComment(id, new StringBuilder(field[7]));
		kickstarter.setCash(id, Integer.parseInt(field[5]));

	}

	private Calendar translateDate(String field) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("d.MM.yyyy");
		try {
			calendar.setTime(sdf.parse(field));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	public void saveBase(Category kickstarter){
		
		String information = kickstarter.saveProject();
		
		try (PrintWriter pw = new PrintWriter("source/MemoryCard.txt")){
			pw.println(information);	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	public  void loadBaseFromTemporarilySolution() { // until we got real base

		String newLine = System.lineSeparator();
		kickstarter.category
				.add(new Project(
						1,
						"Liar",
						" Epimendies paradox",
						"PARADOX",
						500,
						Calendar.getInstance(),
						"A Cretan sails to Greece and says to some Greek "
								+ newLine
								+ "men who are standing upon the shore: `All Cretans are liars.` "
								+ newLine
								+ "Did he speak the truth, or did he lie?",
						"www.google.com"));
		kickstarter.category
				.add(new Project(
						2,
						"Double Liar",
						"Jordain`s paradox",
						"PARADOX",
						350,
						Calendar.getInstance(),
						"This version of a famous paradox was presented by English mathematician P. E. B. "
								+ newLine
								+ "Jourdain in 1913. The following is written on opposite sides of a card - Back side: "
								+ newLine
								+ "THE SENTENCE ON THE OTHER SIDE OF THIS CARD IS TRUE. Face side:THE SENTENCE ON THE "
								+ newLine + "OTHER SIDE OF THIS CARD IS FALSE.",
						"www.bla=bla.com"));
		kickstarter.category
				.add(new Project(
						3,
						"Barber",
						"Rusell`s paradox",
						"PARADOX",
						780,
						Calendar.getInstance(),
						"In a village, the barber shaves everyone who does not shave "
								+ newLine
								+ "himself/herself, but no one else. Who shaves the barber?",
						"www.nasa.com"));
		kickstarter.category
				.add(new Project(
						4,
						"Have",
						"IS IT POSSIBLE TO GIVE WHAT WE DON'T HAVE?",
						"SOPHISM",
						390,
						Calendar.getInstance(),
						"Yes, greedy man gives his cash with sorrow. However, "
								+ newLine
								+ "he doesn't have the cash with sorrow, so he gives what he doesn't have.",
						"www.apple.com"));
		kickstarter.category
				.add(new Project(
						5,
						"WHAT IS BETTER ",
						"WHAT IS BETTER - ETERNAL BLISS OR A SIMPLE BREAD?",
						"SOPHISM",
						780,
						Calendar.getInstance(),
						"What is better than eternal bliss? Nothing. But a slice of bread is better "
								+ newLine
								+ "than nothing. So a slice of bread is better than eternal bliss.",
						"www.music.com"));
		kickstarter.category
				.add(new Project(
						6,
						"Bill Clinton",
						"2012 DNC Speech",
						"APORIA",
						990,
						Calendar.getInstance(),
						"You see, we believe that ‘We’re all in this together’ is a far better "
								+ newLine
								+ "philosophy than ‘You’re on your own.’ So who’s right?",
						"www.della.com"));
		kickstarter.category
				.add(new Project(
						7,
						"Romeo & Juliet",
						"William Shakespeare",
						"APORIA",
						2100,
						Calendar.getInstance(),
						"What’s in a name? That which we call a rose by any other name would smell as sweet.",
						"www.shakspear.com"));
	}

}
