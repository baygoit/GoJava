import java.util.Random;

public class Project {
	private final int MAX_PROJECT_COST = 1_000_000;
	private String name;
	private String description;
	private ProjectParameters param;

	public Project(String name, int num) {
		param = new ProjectParameters();
		Random rand = new Random();
		this.name = name;
		description = "Decription of project " + num;
		param.setCost(rand.nextInt(MAX_PROJECT_COST));
		param.setAlreadyCollected(rand.nextInt(param.getCost()));
		param.setDays(rand.nextInt(365));
	}

	public ProjectParameters getParameters() {
		return param;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
