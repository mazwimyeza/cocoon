package com.myeza.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "posts")
@Data
@AllArgsConstructor
public class Post {

	@Id
	private String id;
	
	@NotBlank
	@Size(min=10, max=400)
	private final String text;
	
	@PastOrPresent
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private final LocalDate createdAt;
	
	@DBRef
	private List<Campaign> campaigns;
	
	@PositiveOrZero
	private int endorsement;
	
	@PositiveOrZero
	private int engagement;
	
	
}
