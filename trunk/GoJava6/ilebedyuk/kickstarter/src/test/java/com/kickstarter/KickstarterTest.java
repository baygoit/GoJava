package com.kickstarter;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Игорь on 22.02.2016.
 */
public class KickstarterTest {
   @Test
    public void stub_and_dummy (){
       Categories categories = new Categories();
       Projects projects = new Projects();

       IO io = new IO() {
            public int read() {
                return 0;
            }

            public void print(String message) {}
        };

        Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator());
        kickstarter.run();
    }

    class FakeIO implements IO {
        private List<String> messages = new LinkedList<>();
        private List<Integer> input = new LinkedList<>();

        public FakeIO(Integer... input) {
            this.input = new LinkedList<>(Arrays.asList(input));
        }

        public int read() {
            return input.remove(0);
        }

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
        public String nextQuote(){
            return "quote";
        }
    }

    @Test
    public void fake() {
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Projects projects = new Projects();

        FakeIO io = new FakeIO(1, 0, 0);

        Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote\n" +
                ", Выберите категорию (или 0 для выхода):\n" +
                ", [1 - category1, 2 - category2]\n" +
                ", Вы выбрали категорию: category1\n" +
                ", ------------------------------------------\n" +
                ", Проектов в категории нет!. Нажмите 0 - для выхода\n" +
                ", Выберите категорию (или 0 для выхода):\n" +
                ", [1 - category1, 2 - category2]\n" +
                ", Спасибо за использование нашей программы!\n" +
                "]", io.getMessages().toString());
    }

    @Test
    public void shouldMenuWithProject(){
        Categories categories = new Categories();
        Category category = new Category("category1");
        categories.add(category);
        Projects projects = new Projects();

        Project project1 = new Project("project1", 100, 1000, "video1", "link1");
        projects.add(project1);
        project1.setCategory(category);

        Project project2 = new Project("project2", 200, 2000, "video2", "link2");
        projects.add(project2);

        project2.setHistory("history");
        project2.setQuetionAnswer("QA");
        project2.setCategory(category);

        FakeIO io = new FakeIO(1, 2, 0, 0, 0, 0);

        Kickstarter kickstarter = new Kickstarter(categories, projects, io, new StubQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote\n" +
                ", Выберите категорию (или 0 для выхода):\n" +
                ", [1 - category1]\n" +
                ", Вы выбрали категорию: category1\n" +
                ", ------------------------------------------\n" +
                ", 1 - , project1\n" +
                ", video1\n" +
                ", Нужно собрать 100 грн за 1000 дней\n" +
                ", Уже собрали: 0 грн\n" +
                ", ------------------------------------------\n" +
                ", 2 - , project2\n" +
                ", video2\n" +
                ", Нужно собрать 200 грн за 2000 дней\n" +
                ", Уже собрали: 0 грн\n" +
                ", ------------------------------------------\n" +
                ", Выберите проект: [1..2] или 0 для выхода\n" +
                ", Вы выбрали проект: project2\n" +
                ", ------------------------------------------\n" +
                ", project2\n" +
                ", video2\n" +
                ", Нужно собрать 200 грн за 2000 дней\n" +
                ", Уже собрали: 0 грн\n" +
                ", ------------------------------------------\n" +
                ", history\n" +
                ", link2\n" +
                ", QA\n" +
                ", ------------------------------------------\n" +
                ", Выберите, что хотите сделать с проектом: \n" +
                "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n" +
                ", Выберите проект: [1..2] или 0 для выхода\n" +
                ", Выберите категорию (или 0 для выхода):\n" +
                ", [1 - category1]\n" +
                ", Спасибо за использование нашей программы!\n" +
                "]", io.getMessages().toString());
    }

    @Test
    public void mockTest(){
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Projects projects = new Projects();

        //FakeIO io = new FakeIO(1, 0, 0);
        IO io = mock(IO.class);
        QuoteGenerator generator = mock(QuoteGenerator.class);

        Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator);

        when(generator.nextQuote()).thenReturn("quote");
        when(io.read()).thenReturn(1, 0, 0);

        kickstarter.run();

        verify(io).print("quote\n");
        verify(io, times(2)).print("Выберите категорию (или 0 для выхода):\n");
        verify(io, times(2)).print("[1 - category1, 2 - category2]\n");
        verify(io).print("Вы выбрали категорию: category1\n");
        verify(io).print("Проектов в категории нет!. Нажмите 0 - для выхода\n");
        verify(io).print("Спасибо за использование нашей программы!\n");
    }

    @Test
    public void shouldPrintProjectMenu_whenSelectIt(){
        Categories categories = new Categories();
        Category category = new Category("category1");
        categories.add(category);

        Projects projects = new Projects();
        Project project = new Project("project1", 100, 1000, "video1", "link1");
        projects.add(project);
        project.setCategory(category);

        IO io = mock(IO.class);
        QuoteGenerator generator = mock(QuoteGenerator.class);

        Kickstarter kickstarter = new Kickstarter(categories, projects, io, generator);

        when(io.read()).thenReturn(1, 1, 1, 0, 0, 0);

        kickstarter.run();

        verify(io, times(2)).print("Выберите, что хотите сделать с проектом: \n" +
                "[0 - выйти к списку проектов, 1 - инвестировать в проект]\n");
        verify(io).print("Спасибо, что хотите помочь проекту!\n");
    }
}