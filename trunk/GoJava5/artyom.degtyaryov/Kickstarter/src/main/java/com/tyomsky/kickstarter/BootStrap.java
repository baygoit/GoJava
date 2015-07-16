package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.MockDataRegistry;
import com.tyomsky.kickstarter.ui.Console;
import com.tyomsky.kickstarter.ui.Input;

public class BootStrap {

    public static void main(String[] args) {
        Configuration configuration = getConfiguration();
        Kickstarter kickStarter = new Kickstarter();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.initEnviroment(configuration);
        Input input = new Console();
        input.setInputListener(dispatcher);
        kickStarter.init(input, dispatcher);
        kickStarter.run();
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setDataProvider(new MockDataRegistry());
        configuration.setOutput(new Console());
        return configuration;
    }

}
