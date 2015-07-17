package test.goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Projects;
import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MainTest{

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


}