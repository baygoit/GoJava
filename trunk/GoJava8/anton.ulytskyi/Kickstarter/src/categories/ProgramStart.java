package categories;

import java.util.Calendar;

import site.Page;
import site.StartPage;

public class ProgramStart {

	public static void main(String[] args) {

		Book kickstarter = new Book();
		loadBase(kickstarter);
		Page direction = new StartPage(kickstarter);
		direction.openPage();

	}

	private static void loadBase(Book kickstarter) { // temporarily, as a database, not according to code convention, nevermind.
		                                             // until we got real base
		String newLine = System.lineSeparator();
		kickstarter.book.add(new Question(
						1,
						"Liar",
						" Epimendies paradox",
						"PARADOX",
						500,
						Calendar.getInstance(),
						"A Cretan sails to Greece and says to some Greek "+newLine
						+ "men who are standing upon the shore: `All Cretans are liars.` "+newLine
						+ "Did he speak the truth, or did he lie?",
						"www.google.com"));
		kickstarter.book.add(new Question(
				2,
				"Double Liar",
				"Jordain`s paradox",
				"PARADOX",
				350,
				Calendar.getInstance(),
				"This version of a famous paradox was presented by English mathematician P. E. B. "+newLine
				+ "Jourdain in 1913. The following is written on opposite sides of a card - Back side: "+newLine
				+ "THE SENTENCE ON THE OTHER SIDE OF THIS CARD IS TRUE. Face side:THE SENTENCE ON THE "+newLine
				+ "OTHER SIDE OF THIS CARD IS FALSE.",
				"www.bla=bla.com"));
		kickstarter.book.add(new Question(
				3,
				"Barber",
				"Rusell`s paradox",
				"PARADOX",
				780,
				Calendar.getInstance(),
				"In a village, the barber shaves everyone who does not shave "+newLine
				+ "himself/herself, but no one else. Who shaves the barber?",
				"www.nasa.com"));
		kickstarter.book.add(new Question(
				4,
				"Have",
				"IS IT POSSIBLE TO GIVE WHAT WE DON'T HAVE?",
				"SOPHISM",
				390,
				Calendar.getInstance(),
				"Yes, greedy man gives his cash with sorrow. However, "+newLine
				+ "he doesn't have the cash with sorrow, so he gives what he doesn't have.",
				"www.apple.com"));
		kickstarter.book.add(new Question(
				5,
				"WHAT IS BETTER ",
				"WHAT IS BETTER - ETERNAL BLISS OR A SIMPLE BREAD?",
				"SOPHISM",
				780,
				Calendar.getInstance(),
				"What is better than eternal bliss? Nothing. But a slice of bread is better "+newLine
				+ "than nothing. So a slice of bread is better than eternal bliss.",
				"www.music.com"));
		kickstarter.book.add(new Question(
				6,
				"Bill Clinton",
				"2012 DNC Speech",
				"APORIA",
				990,
				Calendar.getInstance(),
				"You see, we believe that ‘We’re all in this together’ is a far better "+newLine
				+ "philosophy than ‘You’re on your own.’ So who’s right?",
				"www.della.com"));
		kickstarter.book.add(new Question(
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
