package ua.com.goit.gojava.kickstarter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class KickstarterTest {

	private QuoteGenerator generator;
	private IO io;
	private Categories categories;
	private Projects projects;
	private Kickstarter kickstarter;

	@Before // это будет запускаться каждый раз перед каждым тестом, вынесем сюда всю общую логику
	public void setup() { // потому мы тут можем все проинитить-связать, а в тестах уже наполнить данными
		generator = mock(QuoteGenerator.class);
		when(generator.nextQuote()).thenReturn("quote");
		
		io = mock(IO.class);
		
		categories = new Categories();
		projects = new Projects();
		
		kickstarter = new Kickstarter(categories, projects, io, generator); // эта строчка тоже дублируется везде
		// Все сработало потому как кикстартер в конструкторе не начинает работу, ему еще надо запуститься методом run 
	}
	
	@Test 
	public void shouldExitFromProgramm_whenExitFromCategoriesMenu() {
		// given
		Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator); 
		
		// when 
		when(io.read()).thenReturn("0");  
		kickstarter.run();
	}

	
	@Test 
	public void shouldNoCategoriesInProject_whenSelectCategory() {
	    // given
		categories.add(new Category("category1"));
		categories.add(new Category("category2"));
		
		// when
		when(io.read()).thenReturn("1", "0", "0");  
		kickstarter.run();

		// then
		List<String> values = assertPrinted(io, 9);
		
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
			"]", values.toString());
	}
	
	@Test 
	public void shouldMenuWithProject() {
	    // given
		Category category = new Category("category1");
		categories.add(category);
		
		Project project1 = new Project("project1", 100, 1000, "video1", "description1");
		projects.add(project1);

		project1.setCategory(category);
		
		Project project2 = new Project("project2", 200, 2000, "video2", "description2");
		projects.add(project2);

		project2.setHistory("history2");
		project2.setQuestionAnswers("QA");
		project2.setCategory(category);
		
		// when
		// проинитим мок - 
		// 1- выбрали категорию 1, 
		// 2 - выбрали второй проект, 
		// 0 - вышли из проекта - это нам надо добавить, раньше такого небыло
		// 0 - вышли из списка проектов, 
		// 0 - вышли изсписка категорий, 
		// 0 - вышли из программы 
		when(io.read()).thenReturn("1", "2", "0", "0", "0", "0"); 

		kickstarter.run();

		// then
		List<String> values = assertPrinted(io, 34);
		
		assertEquals("[quote\n" +
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
			"]", values.toString());
	}
	
	// тест исправил, но мне хотелось бы проверить еще вход в меню оплаты, для этого напишу отдельный тест
	@Test
	public void shouldPrintProjectMenu_whenSelectIt() {
  	    // given
		Category category = new Category("category1");
		categories.add(category);
		
		Project project = new Project("project1", 100, 1000, "video1", "description1");
		projects.add(project);
		project.setCategory(category);	
		
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
		// и тут 
		List<String> values = assertPrinted(io, 34);
		
		assertPrinted(values, "Выберите что хотите сделать с проектом: \n"
				+ "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n");
		assertPrinted(values, "Спасибо, что хотите помочь проекту!\n");
	}
	
	@Test
	public void shouldSelectCtegoryWithoutProjects() {
  	    // given
		categories.add(new Category("category1"));
		categories.add(new Category("category2"));
		
		// when
		// выбрали категорию 1, вышли изсписка категорий, вышли из программы
		// аналог FakeIO io = new FakeIO(1, 0, 0);  
		when(io.read()).thenReturn("1", "0", "0");
		
		kickstarter.run();

		// then
		// то же сделаем тут
		List<String> values = assertPrinted(io, 9);
		
		assertPrinted(values, "quote\n");
		assertPrinted(values, "Вы выбрали категорию: category1\n");
		assertPrinted(values, "[1 - category1, 2 - category2]\n");
		assertPrinted(values, "Выберите категорию (или 0 для выхода):\n");
		assertPrinted(values, "Проектов в категории нет. Нажмите 0 - для выхода.\n");
		assertPrinted(values, "Спасибо за использование нашей программы!\n");
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

		Category category = new Category("category1");
		categories.add(category);
		
		Project project = new Project("project1", TOTAL, 1000, "video1", "description1");
		projects.add(project);
		project.setCategory(category);

		// when
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
		List<String> values = assertPrinted(io, 34);
		
		// а тут проверяем было ли то что мы хотели
		// этот метод так же можно упростить
		assertPrinted(values, "Выберите что хотите сделать с проектом: \n"
				+ "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n");
		assertPrinted(values, "Спасибо, что хотите помочь проекту!\n");
		assertPrinted(values, "Введите имя:\n");
		assertPrinted(values, "Введите номер вашей карточки:\n");
		assertPrinted(values, "Введите размер суммы:\n");                     // Мелкая гадость! \n забыл
		assertPrinted(values, "Спасибо Саша Ваши деньги в размере 25 успешно зачислились на счет проекта!\n");
		
		// сразу же переделаю все тесты под новую архитектуру после коммита, чтобы было все в однмо стиле.
		// нет ничего хуже когда от класса к классу видно как вы эволюционировали :) 
		
		// вот тут получается так называемый мок хелл :) когда система выводит не то, что ожидали, а в чем дело разобраться
		// без дебаггера сложно... Потому моками не стоит злоупотреблять
	}

	// это наши тестовые методы, нет ничего страшного что тут в тесте появляется код 
	// главное чтобы тесты оставались читабельными...
	private void assertPrinted(List<String> values, String expected) {
		assertTrue("Actual data: \n" + values.toString() + "\n\n doesn't contain: \n" + expected, // сообщение что напечатается в случае фейла
				values.contains(expected)); // а тут проверка
	}

	private List<String> assertPrinted(IO io, int times) {
		// это просто надо запомнить :) магия Мокито
		// эту магию я предлагаю вынести в метод, чтобы от греха подальше 
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);;
		verify(io, times(times)).print(captor.capture());
		// так получаем список того, что печатали в принтере
		List<String> values = captor.getAllValues();
		return values;
	}
}
