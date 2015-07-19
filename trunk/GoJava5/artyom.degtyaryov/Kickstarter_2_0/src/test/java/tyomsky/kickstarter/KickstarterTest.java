package tyomsky.kickstarter;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class KickstarterTest {

    class FakeIO implements IO {

        private List<String> messages = new LinkedList<>();
        private List<Integer> input = new LinkedList<>();

        @Override
        public int read() {
            return input.remove(0);
        }

        @Override
        public void println(String message) {
            messages.add(message);
        }

        public FakeIO(Integer... input) {
            this.input = new LinkedList<>(Arrays.asList(input));
        }

        public List<String> getMessages() {
            return messages;
        }

        public List<Integer> getInput() {
            return input;
        }
    }

    class StabQuoteGenerator extends QuoteGenerator {

        private String quote;

        public StabQuoteGenerator() {
            super(new Random());
        }

        @Override
        public String getQuote() {
            return "quote";
        }
    }
    @Test
    public void fakeCategoryNavigation () {
        FakeIO io = new FakeIO(1, 0, 0);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Kickstarter kickstarter = new Kickstarter(categories, new ArrayList<Project>(), io, new StabQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote, 1: category1, 2: category2, " +
                "Make a choice (0 for exit): , " +
                "You have chosen: category1, " +
                "------------------------------------------------------, " +
                "Make a choice (0 for exit): , 1: category1, 2: category2, " +
                "Make a choice (0 for exit): ]", io.getMessages().toString());
    }

    @Test
    public void fakeCategoryAndProjectsNavigation () {
        FakeIO io = new FakeIO(1, 1, 0, 0);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        Kickstarter kickstarter = new Kickstarter(categories, new ArrayList<Project>(), io, new StabQuoteGenerator());
        kickstarter.run();
        assertEquals("[quote, 1: category1, 2: category2," +
                " Make a choice (0 for exit): , " +
                "You have chosen: category1, " +
                "------------------------------------------------------," +
                " Make a choice (0 for exit): ," +
                " You have chosen wrong menu index 1," +
                " Make a choice (0 for exit): , 1: category1," +
                " 2: category2, Make a choice (0 for exit): ]", io.getMessages().toString());
    }

}