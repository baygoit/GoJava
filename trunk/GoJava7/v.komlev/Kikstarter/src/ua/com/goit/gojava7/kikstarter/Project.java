package ua.com.goit.gojava7.kikstarter;

import java.util.ArrayList;
import java.util.List;

/**
 * class contain list projects, short description and amount first payment
 */
public class Project {

	protected List<String> listPoject = new ArrayList<>();

	public Project() {
		setProjectDefault();
	}

	private void setProjectDefault() {

		listPoject
				.add("\n1 title project:Photo - Green day\n"
						+ "description: take a photo nature, send this foto us, get your present\n"
						+ "fee: 0.5$\n" + "We have already collected: 170$\n"
						+ "to the end of days: 7");
		listPoject
				.add("\n1 title project:Photo - Take around photo\n"
						+ "description: take a photo sunny day, send this foto us, get your discount to attend our event\n"
						+ "fee: 0.1$\n" + "We have already collected: 112$\n"
						+ "to the end of days: 4");
		listPoject
				.add("\n2 title project:Video - Your smile\n"
						+ "description: record on video three of your smile and get on the cover of documents\n"
						+ "fee: voluntary contribution\n"
						+ "We have already collected: 67$\n"
						+ "to the end of days: 7");
		listPoject
				.add("\n2 title project:Video - Smile kids wake up the world\n"
						+ "description: record on video as your child wakes up in the morning and get a ticket to our studio\n"
						+ "fee: 1$\n" + "We have already collected: 215$\n"
						+ "to the end of days: 5");
		listPoject
				.add("\n3 title project:Record - Your song - your rest\n"
						+ "description: record your best song and get the weekend in our camp\n"
						+ "fee: 20$" + "We have already collected: 198$\n"
						+ "We have already collected: 67$\n"
						+ "to the end of days: 5");
	}

	// add new project
	public void setHisProject(String strValue) {
		listPoject.add(strValue);
	}

	public void getProject(Integer intV) {
		for (int i = 0; i < listPoject.size(); i++) {
			String strV = listPoject.get(i);
			if (1 == strV.indexOf(intV.toString())) {
				System.out.println(listPoject.get(i));
			}
		}
	}

}
