package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.MockDataProvider;
import com.tyomsky.kickstarter.ui.Console;
import com.tyomsky.kickstarter.ui.Input;

public class BootStrap {

    public static void main(String[] args) {
        Configuration configuration = getConfiguration();
        Kickstarter kickStarter = new Kickstarter();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.initControllers(configuration);
        Input input = new Console();
        input.setInputListener(dispatcher);
        kickStarter.init(input, dispatcher);
        kickStarter.run();
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setDataProvider(new MockDataProvider());
        configuration.setOutput(new Console());
        return configuration;
    }

}
