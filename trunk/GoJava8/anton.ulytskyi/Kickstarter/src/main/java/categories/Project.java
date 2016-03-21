package categories;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Project {

	public static final String NEW_LINE = System.lineSeparator();
	public static final String BIG_STEP = NEW_LINE + NEW_LINE;
	public static final int MONTH = 30;
	public static final int TRANSLATIONS_INTO_DAYS = 86400000;
	public static final String FOR_GOOD_SAVING = "!@#$%";

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

	protected int id;
	protected String name;
	protected String description;
	protected String type;
	protected int needMoney;
	protected int haveMoney;
	protected Calendar start;

	protected StringBuilder comments = new StringBuilder();

	protected String history;
	protected String url;

	public String showShortInformation() {
		String information = name + " (" + description + "). Budget: "
				+ haveMoney + "USD/" + needMoney + "USD. Days left: "
				+ getDaysLeft(start) + " days. id: " + id + NEW_LINE;
		return information;
	}

	public String openProfile(int id) {
		String allcomments = comments.toString();
		String discussion [] = allcomments.split(FOR_GOOD_SAVING);
		
		String information = name + " (" + description + "). Budget: "
				+ haveMoney + "USD/" + needMoney + "USD. Days left: "
				+ getDaysLeft(start) + " days." + BIG_STEP + history + BIG_STEP
				+ url + BIG_STEP+"Comments: ";
		
		StringBuilder text = new StringBuilder(information);
		for(int parts = 0; parts<discussion.length; parts++){
			text.append(NEW_LINE+discussion[parts]);
		}
		String finalText =text.toString().replace(FOR_GOOD_SAVING, NEW_LINE);
		return finalText;
	}

	public String getDaysLeft(Calendar start) {

		Calendar today = Calendar.getInstance();
	
		long difference = today.getTimeInMillis() - start.getTimeInMillis();
		int daysofproject = (int) (difference / TRANSLATIONS_INTO_DAYS);
		if (daysofproject <= MONTH) {
			return "" + (MONTH - daysofproject);
		} else {
			return "time is up";
		}
	}

	public void invest(int money) {
		this.haveMoney = haveMoney + money;
	}
	public void setComments(StringBuilder comments) {
		this.comments = comments;
	}
	public void setHaveMoney(int money) {
		this.haveMoney = money;
	}


	public void writeComment(String author, String text) {
		comments.append(FOR_GOOD_SAVING+author + ": `" + text+"`");
	}
	public String getType() {
		return type;
	}
	public int getId() {
		return id;
	}
	public String savingInBase(){

		String information = id+"|"+name+"|"+description+"|"+type+"|"+needMoney+"|"+haveMoney+"|"+translateDate(start)+"|"+comments.toString()+"|"+history+"|"+url+NEW_LINE;
		return information;
		
	}

	private String translateDate(Calendar start) {
		SimpleDateFormat sdf = new SimpleDateFormat("d.MM.yyyy");
		String date = sdf.format(start.getTime());
		return date;
	}
}