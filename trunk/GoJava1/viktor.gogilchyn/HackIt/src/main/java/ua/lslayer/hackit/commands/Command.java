package ua.lslayer.hackit.commands;

abstract class Command {
	private String description = "Default description template";
	public abstract String runCommand(String args);
//	public void registerInList();
	public String getDescription() {
		return this.description;
	};
}
