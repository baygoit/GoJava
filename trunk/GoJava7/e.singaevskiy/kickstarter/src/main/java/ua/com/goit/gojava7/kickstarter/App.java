package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.goit.gojava7.kickstarter.controller.WelcomePageController;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

public class App {

    public static void main(String[] args) {             
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StorageFactory factory = context.getBean(StorageFactory.class);
        start(factory);
        context.close();
    }

    public static void start(StorageFactory factory) {  

        WelcomePageController page = new WelcomePageController();
        page.setStorageFactory(factory);
        page.setInputReader(new BufferedReader(new InputStreamReader(System.in))); 
        page.setView(new ConsolePrinter(System.out));
        page.dispatch();

    }

}
