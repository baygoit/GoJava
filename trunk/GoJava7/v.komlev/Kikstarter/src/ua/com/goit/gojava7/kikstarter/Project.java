package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;

/**
 * class contain list projects, short description and amount first payment
 */
public class Project {

	protected static List<String> listPoject = new ArrayList<>();

	{
		listPoject
				.add("\ntitle project: Green day\n"
						+ "description: take a photo nature, send this foto us, get your present\n"
						+ "fee: 0.1$" + "We have already collected: 112$\n"
						+ "to the end of days: 4");
		listPoject
				.add("\ntitle project: Your smile\n"
						+ "description: record on video three of your smile and get on the cover of documents\n"
						+ "fee: voluntary contribution\n"
						+ "We have already collected: 67$\n"
						+ "to the end of days: 7");
		listPoject
				.add("\ntitle project: Your song - your rest\n"
						+ "description: record your best song and get the weekend in our camp\n"
						+ "fee: 20$" + "We have already collected: 198$\n"
						+ "We have already collected: 67$\n"
						+ "to the end of days: 5");
	}

}
