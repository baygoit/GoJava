package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.dao.XmlDataProvider;

import java.io.File;

public class Bootstrap {
    public static void main(String[] args) {
        File dataFile = new File("src/main/resources/data.xml");
        File schameFile = new File("src/main/resources/schema.xsd");
        DataProvider dataProvider = XmlDataProvider.getNewInstance(dataFile, schameFile);
        Output output = new ConsoleOutput();

        KickStarter kickStarter = new KickStarter(dataProvider, output);
        kickStarter.run();
    }
}
