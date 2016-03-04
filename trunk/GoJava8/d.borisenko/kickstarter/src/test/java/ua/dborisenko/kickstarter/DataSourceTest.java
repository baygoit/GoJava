package ua.dborisenko.kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataSourceTest {

    @Test
    public void fillAllDailyPhrasesTest() {
        DataSource.allDailyPhrases.clear();
        DataSource.fillAllDailyPhrases();
        assertTrue(DataSource.allDailyPhrases.size() > 0);
    }
    
    @Test
    public void fillAllProjectCategoriesTest() {
        DataSource.allProjectCategories.clear();
        DataSource.fillAllProjectCategories();
        assertTrue(DataSource.allProjectCategories.size() > 0);
    }
    
    @Test
    public void fillAllProjectsTest() {
        DataSource.allProjects.clear();
        DataSource.fillAllProjects();
        assertTrue(DataSource.allProjects.size() > 0);
    }
}
