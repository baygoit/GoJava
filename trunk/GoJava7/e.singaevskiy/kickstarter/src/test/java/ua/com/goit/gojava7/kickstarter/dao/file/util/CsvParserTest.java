package ua.com.goit.gojava7.kickstarter.dao.file.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;

public class CsvParserTest {
    
    String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", Quote.class.getSimpleName());
    
    CsvParser parser;

    private StorageFactory factory = new StorageFactory(DataType.MEMORY);


    @Before
    public void setUp() throws Exception {
        Files.delete(Paths.get(filePath));
        
        parser = new CsvParser();
        parser.setDelimiter(";");
        parser.setLineSeparator("\n");

    }

    @Test
    public void testWriteCollection()  throws Exception {
        List<String> readAllLines;
        List<Reward> rewards = factory.getRewardDAO().getAll();
        parser.write(rewards, filePath);
        readAllLines = Files.readAllLines(Paths.get(filePath));
        assertThat(readAllLines.size(), is(rewards.size()+1));
        
        List<Project> projects = factory.getProjectDAO().getAll();
        parser.write(projects, filePath);
        readAllLines = Files.readAllLines(Paths.get(filePath));
        assertThat(readAllLines.size(), is(projects.size()+1));
    }
    
    @Test
    public void testWriteSingleElement()  throws Exception {
        List<String> readAllLines;
        parser.write(factory.getCategoryDAO().get(0), filePath);
        readAllLines = Files.readAllLines(Paths.get(filePath));
        assertThat(readAllLines.size(), is(1+1));
    }

}
