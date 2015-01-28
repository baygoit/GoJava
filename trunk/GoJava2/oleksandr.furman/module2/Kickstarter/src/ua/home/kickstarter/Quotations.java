package ua.home.kickstarter;

import java.util.Random;

public class Quotations {

	public String nextQuote() {
String[] quotations = new String[] {
		"Нельзя же сказать человеку: «Ты можешь творить. Так давай, твори». \nГораздо вернее подождать, пока он сам не скажет: "
				+ "\n«Я могу творить, и я буду творить, хотите вы этого или нет». (c) Айзек Азимов",
				"Я не хочу создавать что-то для того, чтобы мне платили. \nЯ хочу, чтобы мне платили за то, что я что-то создаю. (c) Леонард Коэн",
				"Ключ к открытию вашей мечты – это, в первую очередь, творчество. (c) Зак Эфрон"			
};
		int index = new Random().nextInt(quotations.length);

		String quote = quotations[index];

		return quote;
	}
}
