package com.gojava6.persistence.transactional;


import com.gojava6.persistence.lesson3.CD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    ApplicationContext context = new ClassPathXmlApplicationContext("transactionalContext.xml");

    CDService service = context.getBean("cDService", CDService.class);

    // Creates and persists a CD
    CD cd = service.createCD(new CD("Selling England by the Pound", "5th studio album by the progressive rock band Genesis", 12.5F, 53.39F, "Progressive Rock"));

    System.out.println("CD Persisted : " + cd);

    // Finds the cd
    cd = service.findCD(cd.getId());

    System.out.println("CD Found     : " + cd);

    // Removes the cd
    service.removeCD(cd.getId());

    System.out.println("CD Removed");

    // Finds the cd
    cd = service.findCD(cd.getId());

    System.out.println("CD Not Found : " + cd);

  }
}


