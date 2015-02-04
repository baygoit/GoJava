package ua.com.scread.kickstarter;

public class Details {
	private String history;
	private String video;
	private FAQ faq;

	public Details(String history, String video, FAQ faq) {
		this.history = history;
		this.video = video;
		this.faq = faq;
	}
	
	public String getHistory() {
		return history;
	}
	
	public String getVideo() {
		return video;
	}
	
	public FAQ getFAQ() {
		return faq;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((faq == null) ? 0 : faq.hashCode());
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
        Details other = (Details) obj;
        if (faq == null) {
            if (other.faq != null)
                return false;
        } else if (!faq.equals(other.faq))
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
