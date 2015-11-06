package ua.com.goit.gojava7.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserCategorySelect {
	private int categoryNumber;

	{
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));
			categoryNumber = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (IOException e) {
			System.out.println("wtf?");
		}
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

}
