package com.kickstarter.beans;

import java.util.Date;

public class Message {
	private User author;
	private String text;
	private Date date;
	private Message replyTo;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Message getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Message replyTo) {
		this.replyTo = replyTo;
	}
}
