package com.myeza.models;

import java.util.Date;

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
	private final Date createAt;
	
	@DBRef(lazy = true)
	private Campaign campaign;
	
	@PositiveOrZero
	private int endorsement;
	
	
	
}
