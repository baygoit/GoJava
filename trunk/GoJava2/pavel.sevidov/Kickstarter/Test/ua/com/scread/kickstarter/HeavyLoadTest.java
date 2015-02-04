package ua.com.scread.kickstarter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class HeavyLoadTest {

    @Test
    public void shouldWork_whenHeavyLoad() {
        Categories categories = new Categories();
        Projects projects = new Projects();
//        for (int i = 0; i < 1000000; i++) {
//            Category category = new Category("category" + i);
//            Project project = new Project("Project" + i, "Description" + i, i, i, 
//                    new Details("Some history" + i, "Video link" + i, new FAQ("Question" + i, "Answer" + i)));
//            project.setCategory(category);
//            projects.add(project);
//            categories.add(category);
//        }
        
        // ArrayList 10 sec
        // LinkedList 4.2 min........
        
        Model model = new Model(categories, projects);
        IO io = mock(IO.class);
        QuoteGenerator quote = mock(QuoteGenerator.class);
        when(io.read()).thenReturn(0);
        
        KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
        
        kickstarter.run();
    }
}
