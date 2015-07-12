package ua.goit.kyrychok.kickstarter;

public class KickStarter {
    private DataProvider dataProvider;
    private Output output;
    private Dispatcher dispatcher;

    public void init(DataProvider dataProvider, Output output) {
        this.dataProvider = dataProvider;
        this.output = output;
    }

    public void run() {
        dispatcher = new Dispatcher(dataProvider, output);
        dispatcher.start();
        Input input = new Input(dispatcher);
        input.listenInput();
    }
}
