import java.util.Random;

public class Project {
	private String name;
	private String description;
	private ProjectParameters param;

	public Project(String name, int num) {
		param = new ProjectParameters();
		Random rand = new Random();
		this.name = name;
		description = "Decription of project " + num;
		param.setCost(rand.nextInt(1_000_000));
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
