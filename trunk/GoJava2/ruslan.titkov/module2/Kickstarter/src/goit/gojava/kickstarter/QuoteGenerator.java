package goit.gojava.kickstarter;

import java.util.Random;

public class QuoteGenerator {
	public String nextQuote() {
		String[] strings = new String[] {
				"Мир спасёт не красота, а мозги ... и массовые расстрелы ... (с) Tor",
				"Красивая женщина радует мужской глаз, некрасивая – женский... (c) ХЗ",
				"Женщина - слабое, беззащитное существо, от которого невозможно спастись ... (c) ХЗ",
				"Мало знать себе цену ... нужно еще и иметь спрос ...! (c) ХЗ",
				
		};
		
		int index = new Random().nextInt(strings.length);
		String string = strings[index];
		return string;
	}
}
