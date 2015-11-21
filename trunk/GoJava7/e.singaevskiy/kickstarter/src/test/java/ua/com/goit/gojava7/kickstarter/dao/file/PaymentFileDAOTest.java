package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;

public class PaymentFileDAOTest {
    Class<Payment> persistentClass = Payment.class;
    PaymentStorage fs;
    List<Payment> list = new ArrayList<>();
    private String filePath = "src/test/resources/storages/file/%name%.CSV".replace("%name%", persistentClass.getSimpleName());
    
    @Before
    public void setUp(){
        
        fs = new PaymentFileDAO(filePath);
        
        list = new Memory().getPayments();
        
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
    public void testAddAllGetAll() {
        fs.clear();
        fs.addAll(list);
        assertThat(fs.getAll(), is(list));
    }

    @Test
    public void testAddGet() {
        int id = 42;
        Payment payment = new Payment(new Memory().getProjects().get(0), null, 0, 0, null);
        fs.add(payment);
        assertThat(fs.get(id), is(payment));
    }
    
    @Test
    public void testGetByProject() {
        Project project2 = new Memory().getProjects().get(0);
        Project project = new Project("proj", "usr", new Category(1,"cat"));
        List<Payment> pList = new ArrayList<>();
        pList.add(new Payment(project2, null, 0, 0, null));
        pList.add(new Payment(project2, null, 0, 0, null));
        
        fs.addAll(pList);
        fs.add(new Payment(new Project(), null, null, 0, 0, null));

        assertThat(fs.getAll(), not(pList));
        assertThat(fs.getByProject(project2), is(pList));
    }

}
