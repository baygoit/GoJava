package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectStorage {
	private List<Project> projects = new ArrayList<>();

	{
		Project movie1 = new Project("Art Cinema", "Movie",
				"We would like to built "
						+ "studio for making art house movies.",
				100000, 10000, new Date());

		projects.add(movie1);

	}
}
