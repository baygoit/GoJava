package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class CategoryDatabaseDaoTest{
    //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
    @Autowired
    CategoryDatabaseDao categoryDatabaseDao;//= applicationContext.getBean(CategoryDatabaseDao.class);
    
    
    public void init(){
    }
    
    public void testCategoryDatabaseDao() {
        
       try {
        if(categoryDatabaseDao.getConnection() != null){
            System.out.println("Sucess");
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    public static void main(String[] args){
        CategoryDatabaseDaoTest test = new CategoryDatabaseDaoTest();
        test.testCategoryDatabaseDao();
        System.out.println(test.categoryDatabaseDao.getAll().size());
    }

}
