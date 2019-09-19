package com.myeza.batch;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.myeza.models.*;

@Configuration
@EnableBatchProcessing
public class TweetDataConversionConfig {
	
	@Autowired
	private JobBuilderFactory jobs;
	
	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	private MongoTemplate mongo;
	
	
	@Bean
	@StepScope
	public MongoItemReader<ProfileData> ProfileReader() throws MalformedURLException {
		
		MongoItemReader<ProfileData> reader = new MongoItemReader<>();
		reader.setTemplate(mongo);
		reader.setQuery("{}");
		reader.setCollection("profileData");
		reader.setTargetType(ProfileData.class);
		Map<String, Sort.Direction> sort = new HashMap<String, Sort.Direction>();
		sort.put("_id", Sort.Direction.ASC);
		reader.setSort(sort);
		
		return reader;
	}
	
	
	@Bean
	public ItemReader<Tweet> CampaignReader() throws MalformedURLException {
		
		MongoItemReader<Tweet> reader = new MongoItemReader<>();
		reader.setTemplate(mongo);
		reader.setQuery("{}");
		reader.setCollection("campaignData");
		reader.setTargetType(Tweet.class);
		Map<String, Sort.Direction> sort = new HashMap<String, Sort.Direction>();
		sort.put("_id", Sort.Direction.ASC);
		reader.setSort(sort);
		
		return reader;	}
	/*
	@Bean
	public ItemReader<Tweet> PostReader() throws MalformedURLException {
		return null;
	}
	*/
	@Bean
	public ItemProcessor<ProfileData,Profile> ProfileProcessor(){
		return new ProfileItemProcessor();
	}
	
	@Bean
	public ItemProcessor<Tweet,List<Campaign> > CampaignProcessor(){
		return new TweetItemProcessor();
	}
	
	/*
	
	@Bean
	public ItemProcessor<Tweet,Post> PostProcessor(){
		return null;
	}*/
	
	@Bean ItemWriter<Profile> ProfileWriter(){
		return new ProfileWriter();
	}
	
	@Bean ItemWriter<? super List<Campaign>> CampaignWriter(){
		return new CampaignWriter();
	}
	
	/*
	
	@Bean ItemWriter<Post> PostWriter(){
		return null;
	}*/
	
	@Bean 
	Job ProfileConversion() throws MalformedURLException{
		return jobs.get("getProfileJob")
				.incrementer(new RunIdIncrementer())
				.start(convertProfile())
				.build();
	}
	
	@Bean 
	Job CampaignConversion() throws MalformedURLException{
		return jobs.get("getCampaignJob")
				.incrementer(new RunIdIncrementer())
				.start(convertCampaign())
				.build();
	}
	
	/*
	
	@Bean Job PostConversion() throws MalformedURLException{
		return null;
	}*/
	
	@Bean
	public Step convertProfile() throws MalformedURLException{
		return steps.get("convertProfile")
				.<ProfileData, Profile>chunk(5)
				.reader(ProfileReader())
				.processor(ProfileProcessor())
				.writer(ProfileWriter())
				.build();
	}

	@Bean
	public Step convertCampaign() throws MalformedURLException{
		return steps.get("convertCampaign")
				.<Tweet, List<Campaign> >chunk(10)
				.reader(CampaignReader())
				.processor(CampaignProcessor())
				.writer(CampaignWriter())
				.build();
	}
	
	/*
	
	@Bean
	public Step convertPost() throws MalformedURLException{
		return steps.get("convertPost")
				.<Tweet, Post>chunk(5)
				.reader(PostReader())
				.processor(PostProcessor())
				.writer(PostWriter())
				.build();
	}*/
}
