package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import ua.com.goit.gojava7.kickstarter.controller.PageController;
import ua.com.goit.gojava7.kickstarter.controller.WelcomePageController;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.util.Utils;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public class App {

    public static void main(String[] args) {
        start(initDataType(args));
    }

    @SuppressWarnings("rawtypes")
    public static void start(DataType dataType) {  

        PageController page = new WelcomePageController();
        page.setStorageFactory(new StorageFactory(dataType));
        page.setInputReader(new BufferedReader(new InputStreamReader(System.in))); 
        page.setMainPage(new MainPage(System.out));
        page.dispatch();

    }

    private static DataType initDataType(String[] args) {
        Properties properties = Utils.readProperties("./kicks-files/config.properties");
        DataType dataType = DataType.getByStartupKey(properties.getProperty("datatype"));
        System.out.println("Kickstarter runs in " + dataType + " mode");
        return dataType;
    }

}
