
public class Project {

	private String name;
	private String description;
	private String videoLink;
	private String qa;
	private String history;
	private int moneyNeeded;
	private int moneyCollected;
	private int daysLeft;
	private Category parent;
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getMoneyNeeded() {
		return moneyNeeded;
	}

	public int getMoneyCollected() {
		return moneyCollected;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public Project(String name, String decription, int moneyNeeded,
			int moneyCollected, int daysLeft, String history, String videoLink, String qa, Category parent) {
		super();
		this.name = name;
		this.description = decription;
		this.moneyNeeded = moneyNeeded;
		this.moneyCollected = moneyCollected;
		this.daysLeft = daysLeft;
		this.qa = qa;
		this.videoLink = videoLink;
		this.history = history;
		this.parent = parent;
	}

	public void print() {
		Console.clearScreen();
		System.out.println("Project:" + name);
		System.out.println();
		System.out.println("Project information:");
		System.out.println();
		System.out.println("Description: " + description);
		System.out.println();
		System.out.println("Money needed: " + moneyNeeded);
		System.out.println();
		System.out.println("Money collected: " + moneyCollected);
		System.out.println();
		System.out.println("Days left: " + daysLeft);
		System.out.println();
		System.out.println("History: " + history);
		System.out.println();
		System.out.println("Video link: " + videoLink);
		System.out.println();
		System.out.println("QA's: " + qa);
		System.out.println();
		System.out.println();
		System.out.println("0) Exit.");

		int userChois = Console.getUserChois(0,Console.EXIT);
		parent.print();
		
	}

}
