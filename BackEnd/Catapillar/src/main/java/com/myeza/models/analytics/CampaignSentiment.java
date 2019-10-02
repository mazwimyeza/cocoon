package com.myeza.models.analytics;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.myeza.models.Campaign;

import lombok.Data;


/**
 * This class was designed solely because of the inefficiency of the Sentiment Service to quantify campaign sentiments,
 * So for a demonstration fix, it would seem better to store the campaign sentiments in a database and call the database when 
 * necessary.
 * 
 * @author mazwi
 *
 */

@Data
@Document
public class CampaignSentiment {
	
	@Id
	private String id;
	
	@DBRef
    private	Campaign campaign;
	
	private List<MonthSentiment> monthSentiments;


}
