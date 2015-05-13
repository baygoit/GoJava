package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class QuotesGenerator {

    public String nextQuote() {
	String[] strings = new String[] {
		"Start by doing what's necessary; then do what's possible; and suddenly you are doing the impossible.",
		"Perfection is not attainable, but if we chase perfection we can catch excellence.",
		"My favorite things in life don't cost any money. It's really clear that the most precious resource we all have is time.",
		"You have to learn the rules of the game. And then you have to play better than anyone else",
		"Life isn't about finding yourself. Life is about creating yourself." };

	int index = new Random().nextInt(strings.length);
	String string = strings[index];
	return string;
    }
}
