package com.myeza.services.servicers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myeza.services.SentimentService;


import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

@Service
public class SentimentServicer implements SentimentService {

	@Autowired
	StanfordCoreNLP stanfordCoreNLP;

	private ArrayList<String> stopWords;

	public SentimentServicer() {
		String[] stops = { "a", "about", "above", "after", "again", "against", "ain", "all", "am", "an", "and", "any",
				"are", "aren", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between",
				"both", "but", "by", "can", "couldn", "couldn't", "d", "did", "didn", "didn't", "do", "does", "doesn",
				"doesn't", "doing", "don", "don't", "down", "during", "each", "few", "for", "from", "further", "had",
				"hadn", "hadn't", "has", "hasn", "hasn't", "have", "haven", "haven't", "having", "he", "her", "here",
				"hers", "herself", "him", "himself", "his", "how", "i", "if", "in", "into", "is", "isn", "isn't", "it",
				"it's", "its", "itself", "just", "ll", "m", "ma", "me", "mightn", "mightn't", "more", "most", "mustn",
				"mustn't", "my", "myself", "needn", "needn't", "now", "o", "of", "off", "on", "once", "only", "or",
				"other", "our", "ours", "ourselves", "out", "over", "own", "re", "s", "same", "shan", "shan't", "she",
				"she's", "should", "should've", "shouldn", "shouldn't", "so", "some", "such", "t", "than", "that",
				"that'll", "the", "their", "theirs", "them", "themselves", "then", "there", "these", "they", "this",
				"those", "through", "to", "too", "under", "until", "up", "ve", "very", "was", "wasn", "wasn't", "we",
				"were", "weren", "weren't", "what", "when", "where", "which", "while", "who", "whom", "why", "will",
				"with", "won", "won't", "wouldn", "wouldn't", "y", "you", "you'd", "you'll", "you're", "you've", "your",
				"yours", "yourself", "yourselves", "could", "he'd", "he'll", "he's", "here's", "how's", "i'd", "i'll",
				"i'm", "i've", "let's", "ought", "she'd", "she'll", "that's", "there's", "they'd", "they'll", "they're",
				"they've", "we'd", "we'll", "we're", "we've", "what's", "when's", "where's", "who's", "why's",
				"would" };

		this.stopWords = new ArrayList<>();
		for (String stop : stops) {
			stopWords.add(stop);
		}

	}

	@Override
	public int getSentiment(String text) {

		String tweet = cleanTweet(text);

		int mainSentiment = 0;
		if (tweet != null && tweet.length() > 0) {
			int longest = 0;
			Annotation annotation = stanfordCoreNLP.process(tweet);
			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				String partText = sentence.toString();
				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}
			}
		}

		return mainSentiment;
	}

	private String cleanTweet(String tweet) {

		String text = tweet.replaceAll("@\\S+|https?://\\S+", "");
		String[] words = text.toLowerCase().split(" ");
		String newText = "";
		for (String word : words) {
			if (!this.stopWords.contains(word))
				newText += word + " ";
		}

		return newText.trim();
	}

}
