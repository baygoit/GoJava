package ua.lslayer.hackit.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandRunner {
	private List<Command> registeredCommands = new ArrayList<Command> ();
	public void register(Command registrant) {
		this.registeredCommands.add(registrant);
	}
	public void unRegister(Command registrant) {
		if (this.registeredCommands.contains(registrant)) {
			this.registeredCommands.remove(registrant);
		}
	}
	public List<String> getAllDescriptions() {
		List<String> result = new ArrayList<String>();
		for (Command command : this.registeredCommands) {
			result.add(command.getDescription());
		}
		return result;
	}
	public String runCommand(String commandName, String args) {
		for (Command command : this.registeredCommands) {
			if (command.getClass().getSimpleName().toLowerCase().equals(commandName + "command")) return command.runCommand(args);
		}
		return "Unregistered command, try \"help\" to get all available commands!";
	}

}
