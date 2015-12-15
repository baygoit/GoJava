package db;

import entity.City;
import entity.Home;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.SearchService;

import java.util.List;

public class SearchServiceTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @Test
    public void searchHomesByCity_Success(){
        //------------arrange------------
        SearchService searchService = (SearchService) context.getBean("searchService");
        City city = new City("London");

        //------------act------------
        //List<Home> list = searchService.getHomesByCity(city);

        //------------assert------------
       // Assert.assertEquals(list.size(), 23);

    }

}
