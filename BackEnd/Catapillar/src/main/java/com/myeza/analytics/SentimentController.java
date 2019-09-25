package com.myeza.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.services.SentimentService;

@RestController
public class SentimentController {
	
	@Autowired
	SentimentService sentimentService;
	
	@RequestMapping("/")
	public double getSentiment() {
		return this.sentimentService.getSentiment("I love huawei");
	}

}
