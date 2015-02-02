package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class QuoteGenerator {
	private Random random;

	public QuoteGenerator(Random random) {
		this.random = random;
	}
	
	public String nextQuote() {
		String[] strings = new String[] {
					"Каждый человек - творческая личность (с) Саня",
					"У тебя все получится - главное начать (с) Саня",
					"В трудные минуты поможет друг (с) Саня",
					"Все будет хорошо! (с) Саня",
					"Сделай это! (с) Саня",
				};
		int index = random.nextInt(strings.length);  
		String string = strings[index];
		return string;
	}
}
