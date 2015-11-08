package home.timaPeaceWorld.GoJava2.basics;
public class ButtonsProperties {
	private String titleOfButtons;
	private String language;
	private String sentence;

	public ButtonsProperties(String titleOfButtons, String sentence, String language) {
		this.titleOfButtons = titleOfButtons;
		this.language = language;
		this.sentence = sentence;
	}
	
	public String getTitleOfButtons() {
		return titleOfButtons;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getSentence() {
		return sentence;
	}
}