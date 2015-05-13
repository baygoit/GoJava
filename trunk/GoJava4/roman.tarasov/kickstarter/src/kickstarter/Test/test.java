package kickstarter.Test;

import static org.junit.Assert.*;

import kickstarter.UserInterface;


import org.junit.Test;

import Runner.KickstarterRun;

public class test {

	@Test
	public void test() {
		KickstarterRun runner = new KickstarterRun();
		UserInterface ui = new TestUI();
		runner.newKickstarter();
		runner.kickstarterLoader();
		runner.kickstarterStart(ui);
	}
}


