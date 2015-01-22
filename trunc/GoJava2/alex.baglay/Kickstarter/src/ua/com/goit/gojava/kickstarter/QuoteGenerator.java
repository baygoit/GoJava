package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class QuoteGenerator {
	public String nextQuote() {
		String[] strings = new String[] {
					"Каждый человек - творческая личность (с) Саня",
					"У тебя все получится - главное начать (с) Саня",
					"В трудные минуты поможет друг (с) Саня",
					"Все будет хорошо! (с) Саня",
					"Сделай это! (с) Саня",
				};
		int index = new Random().nextInt(strings.length);  
		String string = strings[index];
		return string;
	}
}
