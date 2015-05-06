package v01;

class Project {
	
	private String name;
	private String shortDescription;
	private int requiredAmount;
	private int alreadyCollected;
	private int daysLeft;
	private String fullDescription;
	private String videoLink;
	private String question;
	private String answer;
	
	public Project(String name, String shortDescription, int requiredAmount,
			int alreadyCollected, int daysLeft, String fullDescription,
			String videoLink, String question, String answer) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.requiredAmount = requiredAmount;
		this.alreadyCollected = alreadyCollected;
		this.daysLeft = daysLeft;
		this.fullDescription = fullDescription;
		this.videoLink = videoLink;
		this.question = question;
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(int requiredAmount) {
		this.requiredAmount = requiredAmount;
	}

	public int getAlreadyCollected() {
		return alreadyCollected;
	}

	public void setAlreadyCollected(int alreadyCollected) {
		this.alreadyCollected = alreadyCollected;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getQuastion() {
		return question;
	}

	public void setQuastion(String quastion) {
		this.question = quastion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
	
	
	
}