package ua.com.goit.gojava7.kickstarter.dao.file.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;

public class CsvParserTest {

    String filePath = "src/test/resources/storages/file/test.CSV";

    CsvParser parser;

    private StorageFactory factory = new StorageFactory(DataType.MEMORY);

    @Before
    public void setUp() throws Exception {
        Path path = Paths.get(filePath);
        if (path.toFile().exists()) {
            Files.delete(path);
        }

        parser = new CsvParser();
        parser.setDelimiter(";");
        parser.setLineSeparator("\n");
        parser.setHasHeader(true);

    }
    
    @After
    public void tearDown() throws Exception {
        Path path = Paths.get(filePath);
        if (path.toFile().exists()) {
            Files.delete(path);
        }
    }

    @Test
    public void testWriteCollection() throws Exception {
        List<String> readAllLines;
        List<Reward> rewards = factory.getRewardDAO().getAll();
        parser.write(rewards, filePath);
        readAllLines = Files.readAllLines(Paths.get(filePath));
        assertThat(readAllLines.size(), is(rewards.size() + 1));
    }

    @Test
    public void testWriteSingleElement() throws Exception {
        List<String> readAllLines;
        parser.write(factory.getCategoryDAO().get(0), filePath);
        readAllLines = Files.readAllLines(Paths.get(filePath));
        assertThat(readAllLines.size(), is(1 + 1));
    }

    @Test
    public void testRead() throws Exception {
        List<Category> before = factory.getCategoryDAO().getAll();
        parser.write(before, filePath);

        List<Category> after = parser.read(filePath, Category.class);
        assertThat(after, is(before));
    }

    @Test
    public void testReadRewards() throws Exception {
        List<Reward> before = factory.getRewardDAO().getAll();
        parser.addParserToString("project", (Project value) -> String.valueOf(value.getId()));
        parser.write(before, filePath);

        parser.addParserFromString("project",
                stringValue -> factory.getProjectDAO().get(Integer.parseInt(stringValue)));
        List<Reward> after = parser.read(filePath, Reward.class);
        assertThat(after, is(before));
    }
    
    @Test
    public void testReadProjects() throws Exception {

        List<Project> projects = factory.getProjectDAO().getAll();
        parser.addParserToString("category", (Category value) -> String.valueOf(value.getId()));
        parser.write(projects, filePath);

        parser.addParserFromString("category", stringValue -> {
            int id = Integer.parseInt(stringValue);
            List<Category> categories = factory.getCategoryDAO().getAll();
            for (Category category : categories) {
                if (category.getId() == id) {
                    return category;
                }
            }
            return null;
        });
        List<Project> afterProject = parser.read(filePath, Project.class);
        assertThat(afterProject, is(projects));
    }

}
