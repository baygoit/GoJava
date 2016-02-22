package com.kickstarter;

import org.junit.Test;

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

            public void print(String message) {

            }
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
}