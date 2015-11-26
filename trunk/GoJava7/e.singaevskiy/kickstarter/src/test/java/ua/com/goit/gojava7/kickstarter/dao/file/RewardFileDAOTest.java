package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardFileDAOTest {
    Class<Reward> persistentClass = Reward.class;
    RewardFileDAO fs;
    List<Reward> list = new ArrayList<>();

    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%",
            persistentClass.getSimpleName());

    @Before
    public void setUp() {

        fs = new RewardFileDAO(filePath);

        list.add(new Reward(1, 1, "a1", 100L));
        list.add(new Reward(2, 1, "a2", 200L));
        list.add(new Reward(3, 2, "a3", 300L));

        fs.clear();
        fs.addAll(list);

    }

    @After
    public void tearDown() throws Exception {
        Path path = Paths.get(filePath);
        if (path.toFile().exists()) {
            Files.delete(path);
        }
    }

    @Test
    public void testGetAll() {
        assertThat(fs.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        int id = 42;
        Reward reward = new Reward(id, 1, "a1", 100L);
        fs.add(reward);
        assertThat(fs.get(id), is(reward));
    }

    @Test
    public void testAddAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }

}
