package ua.com.scread.kickstarter;

public class Controller {
	private Model model;
    private View view;
    private Scan scan;

    public Controller(Model model, View view, Scan scan) {
        this.model = model;
        this.view = view;
        this.scan = scan;
    }

    public void start() {
        model.init();
        view.greed();
    }

}
