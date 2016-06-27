package com.iezzi.wp.api.response;

import java.util.List;

public class TimelineResponse {

	private int count;
	private List<TimelineItem> timelineItems;

	public TimelineResponse() {}
	
	public List<TimelineItem> getTimelineItems() {
		return timelineItems;
	}

	public void setTimelineItems(List<TimelineItem> timelineItems) {
		this.timelineItems = timelineItems;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
