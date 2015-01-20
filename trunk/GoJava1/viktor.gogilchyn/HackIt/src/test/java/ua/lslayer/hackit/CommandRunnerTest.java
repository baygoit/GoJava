package ua.lslayer.hackit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.lslayer.hackit.commands.CommandRunner;
import ua.lslayer.hackit.commands.RegisterCommand;

public class CommandRunnerTest {
	private static CommandRunner runner;
	@BeforeClass
	public static void init() {
		runner = new CommandRunner();
		runner.register(new RegisterCommand());
	}
    @Test
    public void test() {
    	assertEquals(runner.runCommand("register", null), "Something gone wrong, please contact the developer!");
    	assertEquals(runner.runCommand("register", ""), "Bad arguments, usage: \"register <new account name> <new password>");
    	assertEquals(runner.runCommand("register", "newacc newpass"), "Your new login is newacc, password is newpass");
    }

}
