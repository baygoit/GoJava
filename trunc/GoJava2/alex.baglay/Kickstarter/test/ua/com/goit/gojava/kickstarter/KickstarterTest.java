package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class KickstarterTest {

	@Test 
	public void stub_and_dummy() {
		// given
		Categories categories = new Categories();
		Projects projects = new Projects();
		IO io = new IO() { 
			@Override
			public String read() {
				return "0";
			}
			
			@Override
			public void print(String message) {
				// do nothing
			}
		};
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator()); 
		
		kickstarter.run();
	}

	class FakeIO implements IO {
		private List<String> messages = new LinkedList<String>(); 
		private List<String> input = new LinkedList<String>(); 

		public FakeIO(String... input) { // делаем везде string
			this.input = new LinkedList<String>(Arrays.asList(input));  
		}
		
		@Override
		public String read() {
			return input.remove(0); 
		}

		@Override
		public void print(String message) {
			messages.add(message); 
		}

		public List<String> getMessages() {
			return messages;
		}
	}
	
	class StubQuoteGenerator extends QuoteGenerator {
		public StubQuoteGenerator() {
			super(new Random());
		}
		
		@Override
		public String nextQuote() {
			return "quote"; 
		}
	}
	
	@Test 
	public void fake() {
	    // given
		Categories categories = new Categories();
		categories.add(new Category("category1"));
		categories.add(new Category("category2"));
		Projects projects = new Projects();
		FakeIO io = new FakeIO("1", "0", "0");  
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator()); 
		
		// when
		kickstarter.run();

		// then
		assertEquals(
			"[quote\n" + 
			", Выберите категорию (или 0 для выхода):\n" +
			", [1 - category1, 2 - category2]\n" +
			", Вы выбрали категорию: category1\n" +
			", --------------------------------------\n" +
			", Проектов в категории нет. Нажмите 0 - для выхода.\n" +
			", Выберите категорию (или 0 для выхода):\n" +
			", [1 - category1, 2 - category2]\n" +
			", Спасибо за использование нашей программы!\n" +
			"]", io.getMessages().toString());
	}
	
	@Test 
	public void shouldMenuWithProject() {
	    // given
		Categories categories = new Categories();
		Category category = new Category("category1");
		categories.add(category);
		
		Projects projects = new Projects();
		Project project1 = new Project("project1", 100, 1000, "video1", "description1");
		projects.add(project1);

		project1.setCategory(category);
		
		Project project2 = new Project("project2", 200, 2000, "video2", "description2");
		projects.add(project2);

		project2.setHistory("history2");
		project2.setQuestionAnswers("QA");
		project2.setCategory(category);
		
		// проинитим fake - 
		// 1- выбрали категорию 1, 
		// 2 - выбрали второй проект, 
		// 0 - вышли из проекта - это нам надо добавить, раньше такого небыло
		// 0 - вышли из списка проектов, 
		// 0 - вышли изсписка категорий, 
		// 0 - вышли из программы 
		FakeIO io = new FakeIO("1", "2", "0", "0", "0", "0"); 
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator()); 
		
		// when
		kickstarter.run();

		// then
		assertEquals(
			"[quote\n" +
			", Выберите категорию (или 0 для выхода):\n" +
			", [1 - category1]\n" +
			", Вы выбрали категорию: category1\n" +
			", --------------------------------------\n" +
			", 1 - , project1\n" +
			", description1\n" +
			", Уже собрали 100 грн за 1000 дней\n" +
			", Надо собрать 0 грн\n" +
			", --------------------------------------\n" +
			", 2 - , project2\n" +
			", description2\n" +
			", Уже собрали 200 грн за 2000 дней\n" +
			", Надо собрать 0 грн\n" +
			", --------------------------------------\n" +
			", Выберите проект: [1...2] или 0 для выхода\n" +
			", Вы выбрали проект: project2\n" +
			", --------------------------------------\n" +
			", project2\n" +
			", description2\n" +
			", Уже собрали 200 грн за 2000 дней\n" +
			", Надо собрать 0 грн\n" +
			", --------------------------------------\n" +
			", history2\n" +
			", video2\n" +
			", QA\n" +
			", --------------------------------------\n" +
			", Выберите что хотите сделать с проектом: \n" +
			"[0 - выйти к списку проектов, 1 - инвестировать в проект]\n" +
			", Выберите проект: [1...2] или 0 для выхода\n" +
			", Выберите категорию (или 0 для выхода):\n" +
			", [1 - category1]\n" +
			", Спасибо за использование нашей программы!\n" +
			"]", io.getMessages().toString());
	}
	
	// тест исправил, но мне хотелось бы проверить еще вход в меню оплаты, для этого напишу отдельный тест
	@Test
	public void shouldPrintProjectMenu_whenSelectIt() {
  	    // given
		Categories categories = new Categories();
		Category category = new Category("category1");
		categories.add(category);
		
		Projects projects = new Projects();
		Project project = new Project("project1", 100, 1000, "video1", "description1");
		projects.add(project);
		project.setCategory(category);

		IO io = mock(IO.class);
		QuoteGenerator generator = mock(QuoteGenerator.class);
		
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator); 
		
		// when
		when(generator.nextQuote()).thenReturn("quote");
		// проинитим мок
		// 1 выбрали категорию
		// 1 выбрали проект
		// 1 выбрали оплату
		// 0 вышли из проекта
		// 0 вышли из проектов
		// 0 вышли из категорий (программы)		
		when(io.read()).thenReturn("1", "1", "1", "0", "0", "0");
		
		kickstarter.run();

		// then
		verify(io, times(2)).print("Выберите что хотите сделать с проектом: \n"
				+ "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n");
		verify(io).print("Спасибо, что хотите помочь проекту!\n");
	}
	
	@Test
	public void shouldSelectCtegoryWithoutProjects() {
  	    // given
		Categories categories = new Categories();
		categories.add(new Category("category1"));
		categories.add(new Category("category2"));
		
		Projects projects = new Projects();
		
		IO io = mock(IO.class);
		QuoteGenerator generator = mock(QuoteGenerator.class);
		
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator); 
		
		// when
		when(generator.nextQuote()).thenReturn("quote");
		// проинитим fake - выбрали категорию 1, вышли изсписка категорий, вышли из программы
		// аналог FakeIO io = new FakeIO(1, 0, 0);  
		when(io.read()).thenReturn("1", "0", "0");
		
		kickstarter.run();

		// then
		verify(io).print("quote\n");
		verify(io).print("Вы выбрали категорию: category1\n");
		verify(io, times(2)).print("[1 - category1, 2 - category2]\n");
		verify(io, times(2)).print("Выберите категорию (или 0 для выхода):\n");
		verify(io).print("Проектов в категории нет. Нажмите 0 - для выхода.\n");
		verify(io).print("Спасибо за использование нашей программы!\n");
	}
	
	// я опять скопипастил, что не очень хорошо так как порождает дублирование. 
	// если такео случается часто, пора реакторить
	// а данном случае я пишу интеграционные тесты на сложный объект кикстартер, который внутри себя содержит меню
	// Вместо того чтобы писать юнит тесты на одельный пункт меню.
	// плюс в том, что так тестируется все в связке
	// TODO минус в том, что я постояннро должен заходить вовнутрь меню, где хочу потестить делая лишние движения 
	// потому я поставлю туду и потом подумаю над этим
	@Test
	public void shouldIncomeAmountToProject_whenDonate() {
  	    // given
		int TOTAL = 100; // вот это число должно поменяться

		Categories categories = new Categories();
		Category category = new Category("category1");
		categories.add(category);
		
		Projects projects = new Projects();
		Project project = new Project("project1", TOTAL, 1000, "video1", "description1");
		projects.add(project);
		project.setCategory(category);

		IO io = mock(IO.class);
		QuoteGenerator generator = mock(QuoteGenerator.class);
		
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator); 
		
		// when
		when(generator.nextQuote()).thenReturn("quote");
		// проинитим мок
		// 1 выбрали категорию
		// 1 выбрали проект
		// 1 выбрали оплату
		// ввели имя
		// ввели номер карточки
		// ввели сумму донйшена
		// 000 вышли из всех меню 
		when(io.read()).thenReturn("1", "1", "1", "Саша", "239587623875", "25", "0", "0", "0");
		
		kickstarter.run();

		// then	
		// это просто надо запомнить :) магия Мокито
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);;
		verify(io, times(34)).print(captor.capture());
		// так получаем список того, что печатали в принтере
		List<String> values = captor.getAllValues();
		
		// а тут проверяем было ли то что мы хотели
		assertTrue(values.contains("Выберите что хотите сделать с проектом: \n"
				+ "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n"));
		assertTrue(values.contains("Спасибо, что хотите помочь проекту!\n"));
		assertTrue(values.contains("Введите имя:\n"));
		assertTrue(values.contains("Введите номер вашей карточки:\n"));
		assertTrue(values.contains("Введите размер суммы:\n"));                     // Мелкая гадость! \n забыл
		assertTrue(values.toString(), values.contains("Спасибо Саша Ваши деньги в размере 25 успешно зачислились на счет проекта!\n"));
		
		// сразу же переделаю все тесты под новую архитектуру после коммита, чтобы было все в однмо стиле.
		// нет ничего хуже когда от класса к классу видно как вы эволюционировали :) 
		
		// вот тут получается так называемый мок хелл :) когда система выводит не то, что ожидали, а в чем дело разобраться
		// без дебаггера сложно... Потому моками не стоит злоупотреблять
	}
}
