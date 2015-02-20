public class Project {
	
	private String name;
	private String history;
	private String url;
	private String description;
	private int requiredAmount;
	private int total;
	private int days;

	public Project(String name, String description,String history,String url, int requiredAmount,
			int total, int days) {
		this.name = name;
		this.description = description;
		this.requiredAmount = requiredAmount;
		this.history = history;
		this.url = url;
		this.total = total;
		this.days = days;
		
	}

	public String shortInfo() {
		StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(name).append("\n")
						 .append("Description:        ").append(description)
						 .append("\n").append("Required Amount:    ").append(requiredAmount).append("$")
						 .append("\n").append("Total:              ").append(total).append("$")
						 .append("\n").append("Days:               ").append( days);
		return stringBuilder.toString();
	}
	
	public String allInfo() {
		StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(name).append("\n")
						 .append("Description:        ").append(description)
						 .append("\n").append("Required Amount:    ").append(requiredAmount).append("$")
						 .append("\n").append("Total:              ").append(total).append("$")
						 .append("\n").append("Days:               ").append( days)
						 .append("\n").append("History:            ").append(history)
						 .append("\n").append("URL:                ").append(url);
		return stringBuilder.toString();
	}
}