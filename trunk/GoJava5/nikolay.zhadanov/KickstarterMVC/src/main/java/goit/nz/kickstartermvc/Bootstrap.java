package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.input.Input;
import goit.nz.kickstartermvc.output.ConsoleOutput;
import goit.nz.kickstartermvc.output.Output;
import goit.nz.kickstartermvc.storage.DataStorage;
import goit.nz.kickstartermvc.storage.FileStorage;

public class Bootstrap {
	private static Kickstarter app;
	private static DataStorage storage;
	private static Input input;
	private static Output output;

	public static void main(String[] args) {
		input = new Input();
		output = new ConsoleOutput();
		storage = new FileStorage();
		storage.initStorage();
		app = new Kickstarter(storage, output, input);
		app.run();
	}

}
