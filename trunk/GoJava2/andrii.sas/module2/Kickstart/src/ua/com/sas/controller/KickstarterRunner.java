package ua.com.sas.controller;

import java.util.Random;

import ua.com.sas.model.*;
import ua.com.sas.view.*;

public class KickstarterRunner {
	
	public static void main(String[] args) {
		new Storage(new ConsoleOutput(), new ConsoleInput(), new QuoteGenerator(new Random())).initiate();
	}
}