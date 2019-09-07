package com.myeza.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "campaigns")
@Data
@AllArgsConstructor
public class Campaign {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	@NotBlank
	private String tagline;
	
	@Field("date_created")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date firstOccurance;
	
	@Field("date_ended")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date lastOccurance;
	
	@Positive
	private int engagements;
	
	@DBRef
	private List<Profile> profiles;
	

}
