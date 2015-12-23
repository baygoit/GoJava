package db;

import entity.enums.CityList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CityService;

import java.util.List;


public class CityServiceTest {

    private static ApplicationContext context;

    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }

    @Test
    public void getAllCities_Success(){
        //------------arrange------------
        CityService cityService = (CityService) context.getBean("cityService");

        //------------act------------
        List<CityList> list = cityService.getAllCities();

        //------------assert------------
        Assert.assertEquals(list.size(), 23);
    }

}
