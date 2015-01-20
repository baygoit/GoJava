package ua.lslayer.hackit.commands;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import ua.lslayer.hackit.dao.UserAccountDAO;

public class registerCommand extends Command {
	@Override
	public String runCommand(String args) {
		String [] argsArray = args.split("[ ]+");
		if (argsArray.length != 2) return "Bad arguments, usage: \"register <new account name> <new password>";
		try {
		return UserAccountDAO.create(argsArray[0], argsArray[1]).toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return "Something gone wrong, please contact the developer!"; //Hey, where is my internationalization module?
	}
}
