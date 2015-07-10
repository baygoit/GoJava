package ua.goit.kyrychok;

import ua.goit.kyrychok.common.ConsoleInput;
import ua.goit.kyrychok.common.ConsoleOutput;

public class Bootstrap {

    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        dataProvider.init();
        Kickstarter kickstarter = new Kickstarter(new ConsoleInput(), new ConsoleOutput(), dataProvider);
        kickstarter.run();
    }
}
