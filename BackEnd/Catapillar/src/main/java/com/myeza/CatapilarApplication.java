package com.myeza;

import java.util.Properties;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@ComponentScan("com.myeza")
@SpringBootApplication(scanBasePackages = { "com.myeza.repositories" })
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableMongoRepositories("com.myeza.repositories")
public class CatapilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatapilarApplication.class, args);
	}	

	@Bean
	public StanfordCoreNLP stanfordCoreNLP() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
		return new StanfordCoreNLP(props);
		
	}
	

}
