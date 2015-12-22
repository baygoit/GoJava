package ua.com.goit.gojava7.kickstarter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.com.goit.gojava7.kickstarter.view.View;

public class Launcher1 {
    public static void main(String[] args) {
        ApplicationContext context;
        if (args != null && args.length > 0 && args[0].equals("f")) {
            context = new FileSystemXmlApplicationContext("file-spring-config.xml");
        } else if (args != null && args.length > 0 && args[0].equals("d")) {
            context = new FileSystemXmlApplicationContext("database-spring-config.xml");
        } else {
            context = new FileSystemXmlApplicationContext("inmemory-spring-config.xml");
        }

        View view = context.getBean("view", View.class);
        view.run();
    }
}
