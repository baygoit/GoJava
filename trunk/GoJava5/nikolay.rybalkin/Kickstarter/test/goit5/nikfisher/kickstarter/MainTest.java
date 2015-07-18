package test.goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MainTest{

    public class FakeIO implements InputOutputConsoleInterface{

        private List<Integer> input = new LinkedList<>();
        private List<String> massages = new LinkedList<>();

        public FakeIO(Integer... input){
            this.input = new LinkedList<>(Arrays.asList(input));
        }

        @Override
        public int consoleScan() {
            return input.remove(0);
        }

        @Override
        public void println(String massage) {
            massages.add(massage);
        }

        @Override
        public void print(String massage) {
            massages.add(massage);
        }

        public List<String> getMassage() {
            return massages;
        }
    }

    class StubQuoteGenerate extends QuoteGenerate{

        public StubQuoteGenerate() {
            super(new Random());
        }

        @Override
        public String quoteGenerate(){
            return "Test quote";
        }
    }

    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given
        Categories categories = new Categories();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        categories.add(new Category("category3"));

        Projects projects = new Projects();
        FakeIO io = new FakeIO(1, 0, 0, 0);
        Main main = new Main(categories, projects, io, new StubQuoteGenerate());

        //when
        main.run();

        //then
        assertEquals("[Test quote," +
                        "  ," +
                        " Select category (or 0 to exit): ," +
                        " [1) category1, 2) category2, 3) category3]," +
                        " You selected category: category1," +
                        " Projects in this category do not have to exit, enter 0," +
                        "  ," +
                        " Select category (or 0 to exit): ," +
                        " [1) category1, 2) category2, 3) category3]," +
                        " Sank!]",
                io.getMassage().toString());
    }

    @Test
    public void shouldMenuWithrojects() throws Exception {
        //given
        Categories categories = new Categories();
        Category category = new Category("category1");
        categories.add(category);

        Projects projects = new Projects();

        Project project1 = new Project("Game1 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project1);

        project1.setHistory("history");
        project1.setFaq("QA");
        project1.setCategory(category);
        project1.setVideo("Link Video");

        Project project2 = new Project("Game2 \"Popcorn\"", 10000, 10, "Interesting game");
        projects.add(project2);

        project2.setHistory("history");
        project2.setFaq("QA");
        project2.setCategory(category);
        project2.setVideo("Link Video");


//        projects2.setHistory("History this project");

        FakeIO io = new FakeIO(1, 1, 0, 0, 0);
        Main main = new Main(categories, projects, io, new StubQuoteGenerate());

        //when
        main.run();

        //then
        assertEquals("[Test quote," +
                        "  ," +
                        " Select category (or 0 to exit): ," +
                        " [1) category1], You selected category: category1, 1) ," +
                        " goit5.nikfisher.kickstarter.model.Project name: Game1 \"Popcorn\"," +
                        " Description: Interesting game, Need collected: 10000$, Already collected: 0$," +
                        " Days remaining: 10," +
                        " ---------------------------------------," +
                        "  ," +
                        " 2) ," +
                        " goit5.nikfisher.kickstarter.model.Project name: Game2 \"Popcorn\"," +
                        " Description: Interesting game," +
                        " Need collected: 10000$," +
                        " Already collected: 0$," +
                        " Days remaining: 10," +
                        " ---------------------------------------," +
                        "  ," +
                        " Select project: [0...1 or 0 for exit to the projects list," +
                        " You selected project: Game1 \"Popcorn\"," +
                        " goit5.nikfisher.kickstarter.model.Project detail:," +
                        " goit5.nikfisher.kickstarter.model.Project name: Game1 \"Popcorn\"," +
                        " Description: Interesting game," +
                        " Need collected: 10000$," +
                        " Already collected: 0$," +
                        " Days remaining: 10," +
                        " ---------------------------------------," +
                        "  ," +
                        " history," +
                        " QA," +
                        " QA," +
                        " ---------------------------------------," +
                        " Select project: [0...1 or 0 for exit to the projects list," +
                        "  ," +
                        " Select category (or 0 to exit): ," +
                        " [1) category1]," +
                        " Sank!]",
                io.getMassage().toString());
    }
}