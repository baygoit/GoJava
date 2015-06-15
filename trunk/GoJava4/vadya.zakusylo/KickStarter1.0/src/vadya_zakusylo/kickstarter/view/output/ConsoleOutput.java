package vadya_zakusylo.kickstarter.view.output;

public class ConsoleOutput implements Output {

	@Override
	public void write() {
		System.out.println();
	}

	@Override
	public void write(String string) {
		System.out.println(string);
	}
}
