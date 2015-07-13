package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.MockDataProvider;
import com.tyomsky.kickstarter.ui.Console;

public class BootStrap {

    public static void main(String[] args) {
        Configuration configuration = getConfiguration();
        Kickstarter kickStarter = new Kickstarter();
        kickStarter.init(new Console(), new Dispatcher(configuration));
        kickStarter.run();
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setDataProvider(new MockDataProvider());
        configuration.setOutput(new Console());
        return configuration;
    }

}
