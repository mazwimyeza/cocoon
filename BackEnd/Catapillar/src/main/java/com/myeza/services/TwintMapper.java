package com.myeza.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonEncoding; 
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TwintMapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void parseJSON(String filename) {
		try {
			JsonFactory jfactory = new JsonFactory();
			File source = new File(filename);
			
			JsonParser parser = jfactory.createJsonParser(source);
			
			while (parser.nextToken() != JsonToken.END_OBJECT) {
				String token = parser.getCurrentName();
				
				if("username".equals(token)) {
					//TODO create new Profile if one does not exist already.. then add 'twitter' to list of platforms if it wasn't added already
				}
				
				if("tweet".equals(token)) {
					//TODO this is the text to be added to a post, if a hashtag is available and date and time then new post will be created
				}
				
				if("replies_count".equals(token)) {
					//TODO add number to engagement metric
				}
				
				if("retweets_count".equals(token)) {
					//TODO add number to endorsement metric
				}
				
				if("likes_count".equals(token)) {
					//TODO add number to endorsement metric
				}
				
				if("hashtags".equals(token)) {
					//TODO traverse list of hashtag campaigns
				}
				
				if("retweet".equals(token)) {
					//TODO set retweet boolean... or skip this tweet
				}
				
				
				
				if ("firstname".equals(token)) {
                    parser.nextToken();  //next token contains value
                    String fname = parser.getText();  //getting text field
                    System.out.println("firstname : " + fname);

                }

			}
		}catch(JsonParseException jpe) {
			jpe.printStackTrace();
		}
		catch (JsonGenerationException jge) {
            jge.printStackTrace();
        } catch (JsonMappingException jme) {
            jme.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

	}

}
