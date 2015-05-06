
public class Kickstarter {
	
	public static void main(String[] args) {
		Output output = new ConsoleOut();
		Input input = new ConsoleIn();
		DataSource dataSource = new LocalDataSource();
		
		Kickstarter kickstarter = new Kickstarter(output, input, dataSource);
		kickstarter.run();
	}
	
	private Runner runner;	
	
	public Kickstarter(Output output, Input input, DataSource dataSource) {
		this.runner = new Runner(output, input, dataSource);
	}

	public void run() {
		runner.run();
	}

}
