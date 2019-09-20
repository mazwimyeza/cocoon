package com.myeza;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan("com.myeza")
@SpringBootApplication(scanBasePackages = {"com.myeza.repositories"})
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories("com.myeza.repositories")
public class CatapilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatapilarApplication.class, args);
	}

}
