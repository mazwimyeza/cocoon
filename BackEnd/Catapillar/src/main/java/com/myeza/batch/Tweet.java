package com.myeza.batch;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Tweet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String conversation_id;
	
	private String created_at;
	
	private LocalDate date;
	
	private String timezone;
	
	private String user_id;
	
	private String username;
	
	private String name;
	
	private String place;
	
	private String tweet;
	
	private List<String> mentions;
	
	private List<String> urls;
	
	private List<String> photos;
	
	private int replies_count;
	
	private int retweets_count;
	
	private int likes_count;
	
	private List<String> hashtags;
	
	private List<String> cashtags;
	
	private String link;
	
	private boolean retweet;
	
	private String quote_url;
	
	private String video;
	
	private String near;
	
	private String geo;
	
	private String source;
	
	private String user_rt_id;
	
	private String user_rt;
	
	private String retweet_id;
	
	private List<String[]> reply_to;
	
	private String retweet_date;

}
