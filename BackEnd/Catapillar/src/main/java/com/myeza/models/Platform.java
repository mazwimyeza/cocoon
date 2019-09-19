package com.myeza.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Platform {
	
	@NotBlank
	@Field("platform_name")
	@Pattern(regexp = "twitter|facebook|lindedin", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String platformName;
	
	@Indexed(unique = true)
	@NotBlank
	private String username;
	
	@Positive
	private int audience;
	
}
