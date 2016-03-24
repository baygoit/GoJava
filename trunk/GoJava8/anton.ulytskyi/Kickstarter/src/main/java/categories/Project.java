package categories;

import java.util.Calendar;

public class Project {

	public static final String LINE_SEPARATOR = System.lineSeparator();
	public static final String DOUBLE_LINE_SEPARATOR = LINE_SEPARATOR + LINE_SEPARATOR;
	public static final int DAYS_IN_MONTH = 30;
	public static final int TRANSLATIONS_INTO_DAYS = 86400000;
	public static final String SYMBOL_FOR_NEW_LINE = "!@#$%";

	protected int id;
	protected String name;
	protected String description;
	protected String type;
	protected int needMoney;
	protected int haveMoney;
	protected Calendar start;

	protected String comments = ""; //change visability

	protected String history;
	protected String url;

	public Project(int id, String name, String description, String type,
			int needMoney, Calendar start, String history, String url) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.needMoney = needMoney;
		this.start = start;
		this.history = history;
		this.url = url;
	}

	public String showShortInformation() {
		String information = name + " (" + description + "). Budget: "
				+ haveMoney + "USD/" + needMoney + "USD. Days after start: "
				+ getDaysLeft(start) + " days. id: " + id + LINE_SEPARATOR;
		return information;
	}

	public String openProfile(int id) {
		String allcomments = comments.toString();
		String discussion [] = allcomments.split(SYMBOL_FOR_NEW_LINE);
		
		String information = name + " (" + description + "). Budget: "
				+ haveMoney + "USD/" + needMoney + "USD. Days after start: "
				+ getDaysLeft(start) + " days." + DOUBLE_LINE_SEPARATOR + history + DOUBLE_LINE_SEPARATOR
				+ url + DOUBLE_LINE_SEPARATOR+"Comments: ";
		
		StringBuilder text = new StringBuilder(information);
		for(int parts = 0; parts<discussion.length; parts++){
			text.append(LINE_SEPARATOR+discussion[parts]);
		}
		String finalText =text.toString().replace(SYMBOL_FOR_NEW_LINE, LINE_SEPARATOR);
		return finalText;
	}

	public String getDaysLeft(Calendar start) {

		Calendar today = Calendar.getInstance();
	
		long difference = today.getTimeInMillis() - start.getTimeInMillis();
		int daysofproject = (int) (difference / TRANSLATIONS_INTO_DAYS);
			return ""+daysofproject;
		}
	

	public void invest(int money) {
		this.haveMoney = haveMoney + money;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setHaveMoney(int money) {
		this.haveMoney = money;
	}


	public void writeComment(String author, String text) {
		this.comments =this.comments+SYMBOL_FOR_NEW_LINE+author + ": `" + text+"`";
	}
	public String getType() {
		return type;
	}
	public int getId() {
		return id;
	}

}