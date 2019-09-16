package com.myeza.models;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "profiles")
@Data
@NoArgsConstructor
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
