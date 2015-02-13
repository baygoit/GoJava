package org.goJava2.kickstarter.content;

public class Quote {
	
	private final char copyrightSymbol = 169;
	private String content;
	private String author;
	
	public Quote(String content, String author) {
		this.content = content;
		this.author = author;
	}
	
	public String getQuoteContent() {
		StringBuilder builder = new StringBuilder();
		builder.append("\"").append(content).append("\"")
			.append(copyrightSymbol).append(" ").append(author);
		return builder.toString(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + copyrightSymbol;
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
		Quote other = (Quote) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (copyrightSymbol != other.copyrightSymbol)
			return false;
		return true;
	}
}