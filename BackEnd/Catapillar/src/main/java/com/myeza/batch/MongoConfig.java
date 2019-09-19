package com.myeza.batch;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.mongodb.MongoClient;


@Configuration
public class MongoConfig extends AbstractMongoConfiguration{
	
	@Override
	public MongoClient mongoClient() {
		
		return new MongoClient("localhost");
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "twint_data";
	}
	
	@Override
	@Bean
	public MongoCustomConversions customConversions(){
		
		List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new DocumentProfileConverter());
        converters.add(new MongoLocalDateFromStringConverter());
        converters.add(new MongoLocalTimeFromStringConverter());
        converters.add(new DocumentTweetConverter());
        return new MongoCustomConversions(converters);
		
	}
	
	@ReadingConverter
	private static final class MongoLocalDateFromStringConverter implements Converter<String, LocalDate>{

		@Override
		public LocalDate convert(String source) {
			
			if(source == null)
				return null;
			
			boolean matchFirst = Pattern.matches("\\d{4}-\\d{2}-\\d+", source);
			
			DateTimeFormatter format;
			if(matchFirst)
				format = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
			else
				format = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.US);
			
			
			LocalDate time = LocalDate.parse(source, format);
			return time;
		}
		
	}
	
	@ReadingConverter
	private static final class MongoLocalTimeFromStringConverter implements Converter<String, LocalTime>{

		@Override
		public LocalTime convert(String source) {
			
			
			if(source == null)
				return null;
			
			boolean matchFirst = Pattern.matches("\\d{2}:\\d{2}:\\d{2}", source);
			
			DateTimeFormatter format;
			if(matchFirst)
				format = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
			else
				format = DateTimeFormatter.ofPattern("h:MM a", Locale.US);
			
			LocalTime time = LocalTime.parse(source, format);
			return time;
		}
		
		
	}

}
