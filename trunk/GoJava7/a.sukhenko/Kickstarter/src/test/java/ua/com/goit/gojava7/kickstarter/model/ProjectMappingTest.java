package ua.com.goit.gojava7.kickstarter.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/H2/H2ApplicationContext*.xml")
@Transactional
public class ProjectMappingTest {

    @PersistenceContext
    private EntityManager manager;

    @Test
    public void testAll() {
        Category category1 = new Category();
        category1.setCategoryName("Category 1");
        
        Category category2 = new Category();
        category2.setCategoryName("Category 2");
        
        Project project1 = new Project();
        project1.setProjectName("ProjectName1");
        project1.setProjectHistory("ProjectHistory1");
        project1.setEnddate(LocalDateTime.now().plusDays(1));
        project1.setCategory(category1);
        project1.setDemoLink("demolink1");
        project1.setMoneyNeeded(50001.0);
        project1.setProjectDescription("ProjectDescription1");
       
        Project project2 = new Project();
        project1.setProjectName("ProjectName2");
        project1.setProjectHistory("ProjectHistory2");
        project1.setEnddate(LocalDateTime.now().plusDays(2));
        project1.setCategory(category2);
        project1.setDemoLink("demolink2");
        project1.setMoneyNeeded(50002.0);
        project1.setProjectDescription("ProjectDescription2");
        
        manager.persist(project1);
        manager.persist(project2);
        
       Integer projectId1 = project1.getId();
       Integer categoryId1 = category1.getCategoryId();
       
       
       Project project = manager.find(Project.class,projectId1);
       System.out.println("Project: " + project);
       
       Category category = manager.find(Category.class,categoryId1);
       System.out.println("Category: " + category);
       
       System.out.println("Get project by id = 1");
       
        
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmpty(){
        TypedQuery<Project> query = manager.createNamedQuery("Project.findByProjectName",Project.class);
        List<Project> projects = query.setParameter("projectName", "NoSuchProject").getResultList();
        System.out.println("projects Size: " + projects.size());
        System.out.println(projects.get(0));
    }
    
 
}

