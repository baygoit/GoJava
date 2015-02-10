package ua.com.scread.kickstarter;

public class AdditionalInfo {
	private String history;
	private String video;
	private FAQs faqs;

	public AdditionalInfo(String history, String video, FAQs faqs) {
		this.history = history;
		this.video = video;
		this.faqs = faqs;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((faqs == null) ? 0 : faqs.hashCode());
        result = prime * result + ((history == null) ? 0 : history.hashCode());
        result = prime * result + ((video == null) ? 0 : video.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AdditionalInfo other = (AdditionalInfo) obj;
        if (faqs == null) {
            if (other.faqs != null)
                return false;
        } else if (!faqs.equals(other.faqs))
            return false;
        if (history == null) {
            if (other.history != null)
                return false;
        } else if (!history.equals(other.history))
            return false;
        if (video == null) {
            if (other.video != null)
                return false;
        } else if (!video.equals(other.video))
            return false;
        return true;
    }

}
