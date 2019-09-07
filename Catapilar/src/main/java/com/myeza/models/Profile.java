package com.myeza.models;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "profiles")
@Data
@AllArgsConstructor
public class Profile {
	
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true)
	private String name;
	
	private List<Platform> platforms;
	
	@DBRef
	private List<Campaign> campaigns;

}
