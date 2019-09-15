package com.myeza.batch;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ProfileData {
	
	private String id;
	
	private String name;
	
	private String username;
	
	private String bio;
	
	private String location;
	
	private LocalDate join_date;
	
	private LocalTime join_time;
	
	private int tweets;
	
	private int following;
	
	private int followers;
	
	private int likes;
	
	private int media;
	
	private int private_;
	
	private int verified;
	
	private String profile_image_url;
	
	private String background_image;

}
