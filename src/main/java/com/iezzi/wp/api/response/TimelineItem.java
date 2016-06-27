package com.iezzi.wp.api.response;

public class TimelineItem {

	private String title;
	private String date;
	private String body;
	
	public TimelineItem(
			final String title,
			final String date,
			final String body) {
		this.title = title;
		this.date = date;
		this.body = body;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(final String title) {
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(final String date) {
		this.date = date;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(final String body) {
		this.body = body;
	}
	
}
