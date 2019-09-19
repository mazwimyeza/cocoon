package com.myeza.batch;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.mongodb.DBObject;

@ReadingConverter
public class DocumentTweetConverter implements Converter<DBObject, Tweet>{

	@SuppressWarnings("unchecked")
	@Override
	public Tweet convert(DBObject source) {
		
		Tweet tweet = new Tweet();
		
		tweet.setId((String)source.get("_id"));
		tweet.setConversation_id((String) source.get("conversation_id"));
		tweet.setDate((LocalDate) source.get("date"));
		tweet.setTime((LocalTime) source.get("time"));
		tweet.setTimezone((String) source.get("timezone"));
		tweet.setUser_id((String) source.get("user_id"));
		tweet.setUsername((String) source.get("username"));
		tweet.setName((String) source.get("name"));
		tweet.setPlace((String) source.get("place"));
		tweet.setTweet((String) source.get("tweet"));
		tweet.setMentions((List<String>) source.get("mentions"));
		tweet.setUrls((List<String>) source.get("urls"));
		tweet.setPhotos((List<String>) source.get("user_id"));
		tweet.setReplies_count((int) source.get("replies_count"));
		tweet.setRetweets_count((int) source.get("retweets_count"));
		tweet.setLikes_count((int) source.get("likes_count"));
		tweet.setHashtags((List<String>) source.get("hashtags"));
		tweet.setCashtags((List<String>) source.get("cashtags"));
		tweet.setLink((String) source.get("link"));
		tweet.setRetweet((boolean) source.get("retweet"));
		tweet.setQuote_url((String) source.get("qoute_url"));
		tweet.setVideo((String) source.get("video"));
		tweet.setNear((String) source.get("near"));
		tweet.setGeo((String) source.get("geo"));
		tweet.setSource((String) source.get("source"));
		tweet.setUser_rt_id((String) source.get("user_rt_id"));
		tweet.setUser_rt((String) source.get("user_rt"));
		tweet.setRetweet_id((String) source.get("retweet_id"));
		tweet.setReply_to((List<String[]>) source.get("reply_to"));
		tweet.setRetweet_date((String) source.get("retweet_date"));
			
		return tweet;
	}

}
