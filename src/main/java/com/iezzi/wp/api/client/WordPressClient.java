package com.iezzi.wp.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.iezzi.wp.api.response.OverviewResponse;
import com.iezzi.wp.api.response.PerspectivesResponse;
import com.iezzi.wp.api.response.RecentPostsResponse;
import com.iezzi.wp.api.response.TimelineItem;
import com.iezzi.wp.api.response.TimelineResponse;

public class WordPressClient {

	private Connection connection;
	private Gson gson;
	
	private final static String RECENT_POST_REQ = "api/get_recent_posts?include=id,title,author";
	private final static String OVERVIEW_SECT_REQ = "api/get_post?custom_fields=overview_primary&include=custom_fields&post_id=";
	private final static String TIMELINE_ITEMS_REQ = "api/get_post?include=custom_fields&post_id=";
	private final static String PERSPECTIVE_SECT = "api/get_post?custom_fields=perspective_overview,perspective_question&include=custom_fields&post_id=";
	
	private final static String POST = "post";
	private final static String CUSTOM_FIELDS = "custom_fields";
	private final static String TIMELINE = "timeline";
	
	private final static String TIMELINE_ITEM_TITLE = "_timeline_item_title";
	private final static String TIMELINE_ITEM_DATE = "_timeline_item_date";
	private final static String TIMELINE_ITEM_BODY = "_timeline_item_body";
	
	public WordPressClient(Configuration configuration) {
		connection = new Connection(configuration);
		gson = new GsonBuilder().create();
	}
	
	public RecentPostsResponse getRecentPosts() {
		
		InputStream is = null;
		RecentPostsResponse response = null;
			
		try {
		
			is = connection.getDataStream(RECENT_POST_REQ);
			final Reader reader = new InputStreamReader(is, "UTF-8");
			response = gson.fromJson(reader, RecentPostsResponse.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		return response;
		
	}
	
	public OverviewResponse getOverviewSection(final int id) {
		
		InputStream is = null;
		OverviewResponse response = null;
			
		try {
		
			is = connection.getDataStream(OVERVIEW_SECT_REQ + id);
			final Reader reader = new InputStreamReader(is, "UTF-8");
			response = gson.fromJson(reader, OverviewResponse.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		return response;
		
	}
	
	public TimelineResponse getTimeLineItems(final int id) {
		
		InputStream is = null;
		TimelineResponse response = new TimelineResponse();
		List<TimelineItem> timelineItems = new ArrayList<TimelineItem>();
			
		try {
		
			is = connection.getDataStream(TIMELINE_ITEMS_REQ + id);
			final Reader reader = new InputStreamReader(is, "UTF-8");
			final JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
			
			/***
			 * In order to get all of the timeline items, you need to first find
			 * the total count of timeline items, then find the unknown fields based
			 * on the index (zero-based) and field name. Ugly, but works.
			 */
			response.setCount(jsonObject.
					getAsJsonObject(POST).
					getAsJsonObject(CUSTOM_FIELDS).
					get(TIMELINE).
					getAsInt());
			
			for (int i = 0; i < response.getCount(); i++) {
				
				String title = jsonObject.
						getAsJsonObject(POST).
						getAsJsonObject(CUSTOM_FIELDS).
						get(TIMELINE + "_" + i + TIMELINE_ITEM_TITLE).
						getAsString();
				
				String date = jsonObject.
						getAsJsonObject(POST).
						getAsJsonObject(CUSTOM_FIELDS).
						get(TIMELINE + "_" + i + TIMELINE_ITEM_DATE).
						getAsString();
				
				String body = jsonObject.
						getAsJsonObject(POST).
						getAsJsonObject(CUSTOM_FIELDS).
						get(TIMELINE + "_" + i + TIMELINE_ITEM_BODY).
						getAsString();
				
				timelineItems.add(new TimelineItem(title, date, body));
				
			}
			
			response.setTimelineItems(timelineItems);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		return response;
	}
	
	public PerspectivesResponse getPerspectives(final int id) {
		
		InputStream is = null;
		PerspectivesResponse response = null;
			
		try {
		
			is = connection.getDataStream(PERSPECTIVE_SECT + id);
			final Reader reader = new InputStreamReader(is, "UTF-8");
			response = gson.fromJson(reader, PerspectivesResponse.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		return response;
	}
	
}
