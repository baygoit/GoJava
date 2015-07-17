package test.goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.Main;
import goit5.nikfisher.kickstarter.model.Categories;
import goit5.nikfisher.kickstarter.model.Projects;
import goit5.nikfisher.kickstarter.streams.Read;
import goit5.nikfisher.kickstarter.streams.Write;
import org.junit.Test;

public class MainTest{



    @Test
    public void shouldCategoriesWenNoCategories() throws Exception {
        //given

        //when

        //then
        shouldMainAll();
    }

    public void shouldMainAll() throws Exception {

        Categories categories = new Categories();
        Projects projects = new Projects();
        Read read = new Read() {

            @Override
            public int consoleScan() {
                return 0;
            }
        };

        Write write = new Write() {
            @Override
            public void println(String message) {

            }

            @Override
            public void print(String message) {

            }
        };

        Main main = new Main(categories, projects, read);


        main.run();

}

}