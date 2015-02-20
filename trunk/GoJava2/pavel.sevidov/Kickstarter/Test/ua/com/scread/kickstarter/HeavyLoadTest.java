package ua.com.scread.kickstarter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ua.com.scread.kickstarter.data.Quote;
import ua.com.scread.kickstarter.io.IO;
import ua.com.scread.kickstarter.main.KickstarterRunner;
import ua.com.scread.kickstarter.model.Model;
import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.InMemoryCategories;
import ua.com.scread.kickstarter.storage.InMemoryProjects;
import ua.com.scread.kickstarter.storage.Projects;

public class HeavyLoadTest {

    @Test
    public void shouldWork_whenHeavyLoad() {
        Categories categories = new InMemoryCategories();
        Projects projects = new InMemoryProjects();
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
        Quote quote = mock(Quote.class);
        when(io.read()).thenReturn(0);
        
        KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
        
        kickstarter.run();
    }
}
