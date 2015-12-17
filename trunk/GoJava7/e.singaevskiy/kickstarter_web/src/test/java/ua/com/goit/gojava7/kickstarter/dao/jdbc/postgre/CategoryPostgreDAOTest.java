package ua.com.goit.gojava7.kickstarter.dao.jdbc.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.util.Utils;

@RunWith(value=MockitoJUnitRunner.class)
public class CategoryPostgreDAOTest {

	private JdbcTemplate jdbcTemplate;
	
    CategoryPostgreDAO dao;
    
    List<Category> list;

    @Before
    public void setUp() throws Exception {
        Properties properties = Utils.readProperties("./src/test/resources/storages/db/config.properties");
     
        dao = new CategoryPostgreDAO();
        jdbcTemplate = new JdbcTemplate();
        BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(properties.getProperty("driver"));
		datasource.setUrl(properties.getProperty("url"));
		datasource.setUsername(properties.getProperty("user"));
		datasource.setPassword(properties.getProperty("password"));

		jdbcTemplate.setDataSource(datasource);
		dao.setJdbcTemplate(jdbcTemplate);
        
        list = new ArrayList<>();
        list.add(new Category(1, "c1"));
        list.add(new Category(2, "c2"));      
    }
    
    @After
    public void tearDown() throws Exception {
        dao.clear();
    }

    @Test
    public void testAddGetAll() {   
        dao.addAll(list);
        assertThat(dao.getAll(), is(list));
    }
    
    @Test
    public void testAddGet() {
        Category element = new Category(1, "t1");
        dao.add(new Category(2, "t0"));
        dao.add(element);
        dao.add(new Category(3, "t2"));
        assertThat(dao.get(1), is(element));
    }

}
