package kickstarter;

import datasource.DataSource;
import datasource.LocalDataSource;
import UserInterface.ConsoleIn;
import UserInterface.ConsoleOut;
import UserInterface.Input;
import UserInterface.Output;
import logic.Runner;

public class Kickstarter {

	private Runner runner;
	private static DataSource dataSource;

	public Kickstarter(Output output, Input input, DataSource dataSource) {
		this.runner = new Runner(output, input);
		this.dataSource = dataSource;
	}

	public void run() {
		runner.run();
	}

	public static void main(String[] args) {
		Output output = new ConsoleOut();
		Input input = new ConsoleIn();
		DataSource dataSource = new LocalDataSource();

		Kickstarter kickstarter = new Kickstarter(output, input, dataSource);
		kickstarter.run();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
