package com.gojava6.springioc;



import com.gojava6.springioc.service.CustomerService;
import com.gojava6.springioc.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
        /*CustomerService service = new CustomerServiceImpl();*/

        System.out.println(service.findAll().get(0).getFirstname());
    }

}
