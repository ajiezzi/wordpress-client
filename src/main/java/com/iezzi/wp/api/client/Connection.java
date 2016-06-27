package com.iezzi.wp.api.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

	private HttpURLConnection conn = null;
	private Configuration configuration;
	
	public Connection(final Configuration configuration) {
		this.configuration = configuration;
	}
	
	public InputStream getDataStream(
			final String request) throws IOException {
		
		InputStream is = null;
		
        try {
        	
        	final String endpoint = configuration.getHost() + request;
        	
        	URL url = new URL(endpoint);
            conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            if (conn.getResponseCode() == 200) {
            	is = conn.getInputStream();
            } else {
            	System.out.println("HTTP response code " + conn.getResponseCode() + " for " + url.toString() + " request.");
            	is = conn.getErrorStream();
            }
    		
        } catch (Exception e) {
        	e.printStackTrace();
        } 
        
        return is;
      
	}
	
	public void close() {
		conn.disconnect();
	}
	
}
