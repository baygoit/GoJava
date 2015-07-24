package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.dao.DataProvider;

public class KickStarter {
    private DataProvider dataProvider;
    private Output output;
    private Dispatcher dispatcher;

    public KickStarter(DataProvider dataProvider, Output output) {
        this.dataProvider = dataProvider;
        this.output = output;
    }

    public void run() {
        dispatcher = new Dispatcher();
        dispatcher.init(dataProvider, output);
        Input input = new Input(dispatcher);
        dispatcher.onStart();
        input.listenInput();
    }
}
