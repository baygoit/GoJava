package kickstarter.Test;

import kickstarter.UserInterface;

import org.junit.Test;

import Runner.KickstarterRun;

public class fake_console {

	@Test
	public void test() {
		KickstarterRun runner = new KickstarterRun();
		UserInterface ui = new ExitUI();
		runner.newKickstarter();
		runner.kickstarterLoader();
		runner.kickstarterStart(ui);

	}
}
