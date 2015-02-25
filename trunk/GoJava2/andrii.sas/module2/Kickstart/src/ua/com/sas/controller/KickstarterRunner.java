package ua.com.sas.controller;

import java.util.Random;

import ua.com.sas.model.QuoteGenerator;
import ua.com.sas.model.Storage;
import ua.com.sas.view.ConsoleInput;
import ua.com.sas.view.ConsoleOutput;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		new Storage(new ConsoleOutput(), new ConsoleInput(), new QuoteGenerator(new Random())).initiate();
	}
}