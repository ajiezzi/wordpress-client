package com.iezzi.wp;

import com.iezzi.wp.api.client.Configuration;
import com.iezzi.wp.api.client.WordPressClient;
import com.iezzi.wp.api.response.OverviewResponse;
import com.iezzi.wp.api.response.PerspectivesResponse;
import com.iezzi.wp.api.response.RecentPostsResponse;
import com.iezzi.wp.api.response.RecentPostsResponse.Post;
import com.iezzi.wp.api.response.TimelineItem;
import com.iezzi.wp.api.response.TimelineResponse;


public class TestClient {
	
	private final static String HOST = ""; // Example: http://www.example.com
	private final static String USERNAME = null;
	private final static String PASSWORD = null;
	
    public static void main( String[] args ) {
    	
    	Configuration config = new Configuration(HOST, USERNAME, PASSWORD);
    	
    	// Create a new API client
    	WordPressClient client = new WordPressClient(config);
    	
    	// Get me all of the recent posts
    	RecentPostsResponse response = client.getRecentPosts();
        
    	System.out.println("=================== Recent Posts =======================");
    	for (Post post : response.getPosts()) {
    		System.out.print("ID: " + post.getId());
    		System.out.print(", Title: " + post.getTitle());
    		System.out.println(", Author: " + post.getAuthor().getName());
    	}
    	System.out.println("");
    	
    	// Get the Overview of post #37 (Pittsburgh Penguins)
    	OverviewResponse oResponse = client.getOverviewSection(37);
    	
    	System.out.println("================= Overview Paragraph ===================");
    	System.out.println("Overview Paragraph: " + oResponse.getPost().getCustom_fields().getOverview_primary()[0]);
    	System.out.println("");
    	
    	// Get the activity timeline of post #37 (Pittsburgh Penguins)
    	TimelineResponse timelineResponse = client.getTimeLineItems(37);
    	
    	System.out.println("================= Timeline Items =======================");
    	for (TimelineItem item : timelineResponse.getTimelineItems()) {
    		System.out.print("Date: " + item.getDate());
    		System.out.println(", Title: " + item.getTitle());
    	}
    	System.out.println("");
    	
    	// Get the Overview of post #37 (Pittsburgh Penguins)
    	PerspectivesResponse pResponse = client.getPerspectives(37);
    	
    	System.out.println("================= Perspectives Section ===================");
    	System.out.println("Perspectives Overview: " + pResponse.getPost().getCustom_fields().getPerspective_overview()[0]);
    	System.out.println("Perspectives Question: " + pResponse.getPost().getCustom_fields().getPerspective_question()[0]);
    	System.out.println("");
    	
    }
    
}
