package com.myeza;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.myeza.batch", "com.myeza.services"})
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CatapilarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatapilarApplication.class, args);
	}

}
