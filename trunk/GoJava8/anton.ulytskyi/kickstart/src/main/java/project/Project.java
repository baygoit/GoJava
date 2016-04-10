package project;

import java.util.Calendar;

public class Project {

	private static final String LINE_SEPARATOR = System.lineSeparator();
	private static final String DOUBLE_LINE_SEPARATOR = LINE_SEPARATOR + LINE_SEPARATOR;
	private static final int TRANSLATIONS_INTO_DAYS = 86400000;

	private int id;
	private String name;
	private String category;
	private int haveMoney;
	private int needMoney;
	private Calendar start;
	private String comments;
	private String history;
	private String url;

	public Project(int id, String name,  String category, int haveMoney,
			int needMoney, Calendar start, String comments, String history, String url) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.haveMoney = haveMoney;
		this.needMoney = needMoney;
		this.start = start;
		this.comments = comments;
		this.history = history;
		this.url = url;
	}

	public String showShortInformation() {
		String information = name + ". Budget: "
				+ haveMoney + "USD/" + needMoney + "USD. Days after start: "
				+ getDaysLeft(start) + " days. id: " + id;
		return information;
	}

	public String openProfile(int id) {
		
		String information = "<h1>"+name + "</h1>"+"<br />"+"Budget: "
				+ haveMoney + "USD/" + needMoney + "USD.<br />Days after start: "
				+ getDaysLeft(start) + " days.<br />" +  history 
				+"<br />" +url + "<br /><br />"+"Comments: <br />" +comments;
	
		return information;
	}

	public String getDaysLeft(Calendar start) {

		Calendar today = Calendar.getInstance();
	
		long difference = today.getTimeInMillis() - start.getTimeInMillis();
		int daysofproject = (int) (difference / TRANSLATIONS_INTO_DAYS);
			return ""+daysofproject;
		}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHaveMoney() {
		return haveMoney;
	}
	public void setHaveMoney(int haveMoney) {
		this.haveMoney = haveMoney;
	}
	public int getNeedMoney() {
		return needMoney;
	}
	public void setNeedMoney(int needMoney) {
		this.needMoney = needMoney;
	}
	public Calendar getStart() {
		return start;
	}
	public void setStart(Calendar start) {
		this.start = start;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}