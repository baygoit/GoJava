package ua.com.scread.kickstarter.data;

import ua.com.scread.kickstarter.storage.Bonuses;
import ua.com.scread.kickstarter.storage.FAQs;

public class AdditionalInfo {
	private String history;
	private String video;
	private FAQs faqs;
	private Bonuses bonuses;

	public AdditionalInfo(String history, String video, Bonuses bonuses, FAQs faqs) {
		this.history = history;
		this.video = video;
		this.faqs = faqs;
		this.bonuses = bonuses;
	}
	
	public AdditionalInfo(String history, String video) {
        this.history = history;
        this.video = video;
    }

    public String getHistory() {
		return history;
	}
	
	public String getVideo() {
		return video;
	}
	
	public FAQs getFAQs() {
		return faqs;
	}
	
	public void addFAQ(FAQ faq) {
	    faqs.add(faq);
	}
	
	public void addBonus(Bonus bonus) {
	    bonuses.add(bonus);
	}

	public Bonuses getBonuses() {
	    return bonuses;
	}
	
	public Bonus getBonus(int index) {
	    return bonuses.getBonus(index);
	}

    @Override
    public String toString() {
        return history + ";" + video + ";:" + bonuses.toString() 
                       + ":" + faqs.toString();
    }
}
