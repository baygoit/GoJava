package go_java_4.vadya_zakusylo.kickstarter.output;

public class ConsoleOutput implements Output {

	@Override
	public void write(String string) {
		System.out.println(string);
	}

}
