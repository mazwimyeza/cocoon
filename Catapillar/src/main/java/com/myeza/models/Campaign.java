package com.myeza.models;


import java.time.Instant;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;
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
	private final String tagline;
	
	@CreatedDate
	@PastOrPresent
	@Field("date_created")
	@DateTimeFormat(iso = ISO.DATE)
	private Instant firstOccurance;
	
	
	@PastOrPresent
	@Field("date_ended")
	@DateTimeFormat(iso = ISO.DATE)
	private Instant lastOccurance;
	
	@Positive
	private int engagements;
	
	@DBRef(lazy = true)
	private List<Profile> owners;
	

}
