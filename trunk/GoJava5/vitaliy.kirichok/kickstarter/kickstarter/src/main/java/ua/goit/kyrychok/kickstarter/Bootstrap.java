package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.dao.DbDataProvider;

public class Bootstrap {
    public static void main(String[] args) {

        //Memory Mode
//        DataProvider dataProvider = MemoryDataProvider.getNewInstance();

        //XML mode
//        File dataFile = new File("src/main/resources/data.xml");
//        File schameFile = new File("src/main/resources/schema.xsd");
//        DataProvider dataProvider = XmlDataProvider.getNewInstance(dataFile, schameFile);

        //Database mode
        final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:ORCL";
        final String DB_USER = "kickstarter";
        final String DB_PASSWORD = "123456";
        DataProvider dataProvider = new DbDataProvider(DB_CONNECTION, DB_USER, DB_PASSWORD);

        Output output = new ConsoleOutput();

        KickStarter kickStarter = new KickStarter(dataProvider, output);
        kickStarter.run();
    }
}
