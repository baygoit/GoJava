package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuoteGeneratorTest {

	// мы занаследовались от рендома
	class FakeRandom extends Random {
		private List<Integer> numbers;

		// инитим его своими числами
		public FakeRandom(Integer... numbers) {
			this.numbers = new LinkedList(Arrays.asList(numbers)); // ошибка потому что Arrays.asList создает такой лист из которого потом 
			// нельзя будет удалять :) немодифицируемый
		}
		
		// переопределили в нем метод получения следующего числа
		@Override
		public int nextInt(int i) { // не тот метод переопределили
			return numbers.remove(0); // где берем из списка как из стека, удаляя верхий элемент
		}
	}
	
	@Test
	public void shouldGenerateNewQUote() {
		// given
		// Все, теперь у нас сколько не хзапускай - FakeRandom будет всегда возвращать вначале 0 а потом 1, и значит тест будет всегда проходить
		QuoteGenerator generator = new QuoteGenerator(new FakeRandom(0, 1)); 
		// ничего не поменялось - мы просто вынесли "за скобки" класса зависимость new Random()
		
		// when 
		String quote = generator.nextQuote();
		
		// then
		assertEquals("Каждый человек - творческая личность (с) Саня", quote);
		
		// when 
		String quote2 = generator.nextQuote();
		
		// then
		assertEquals("У тебя все получится - главное начать (с) Саня", quote2);
	} 
}
