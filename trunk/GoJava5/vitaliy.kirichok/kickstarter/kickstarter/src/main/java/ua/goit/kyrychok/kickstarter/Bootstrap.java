package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;
import ua.goit.kyrychok.kickstarter.dao.MemoryDataProvider;

public class Bootstrap {
    public static void main(String[] args) {
        DataProvider dataProvider = MemoryDataProvider.getInstance();
        Output output = new ConsoleOutput();

        KickStarter kickStarter = new KickStarter(dataProvider, output);
        kickStarter.run();
    }
}
