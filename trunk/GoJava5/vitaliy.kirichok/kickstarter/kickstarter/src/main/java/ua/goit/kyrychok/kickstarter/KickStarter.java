package ua.goit.kyrychok.kickstarter;

public class KickStarter {
    private DataProvider dataProvider;
    private Output output;
    private Dispatcher dispatcher;

    public KickStarter(DataProvider dataProvider, Output output) {
        this.dataProvider = dataProvider;
        this.output = output;
    }

    public void run() {
        dispatcher = new Dispatcher(dataProvider, output);
        Input input = new Input(dispatcher);
        dispatcher.onStart();
        input.listenInput();
    }
}
