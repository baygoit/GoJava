package ua.goit.kyrychok;

import ua.goit.kyrychok.common.Input;
import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.controllers.MainPageController;

public class Kickstarter {
    public static final int DEFAULT_POSITION = 0;

    private String helloMessage = "Hello!";
    private Input input;
    private Output output;
    private DataProvider dataProvider;
    private MainPageController controller;

    public Kickstarter(Input input, Output output, DataProvider dataProvider) {
        this.input = input;
        this.output = output;
        this.dataProvider = dataProvider;
        controller = new MainPageController(dataProvider, input, output);
    }

    public void run() {
        //hello

        input.init();
        controller.run();
        input.close();
    }
}
