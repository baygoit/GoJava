package ua.com.goit.gojava.kickstarter;

import java.util.Random;

public class QuoteGenerator {
	public String nextQuote() {
		String[] strings = new String[] {
					"Каждый человек - творческая личность (с) Саня",
					"У тебя получится - стоит только начать (с) Саня",
					"Иногда чтобы закончить требуется помощь (с) Саня",
					"У тебя получится! (с) Саня",
					"Все будет хорошо! (с) Саня",
				};
		int index = new Random().nextInt(strings.length);  
		String string = strings[index];
		return string;
	}
}
