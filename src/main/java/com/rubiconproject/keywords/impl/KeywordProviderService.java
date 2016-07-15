package com.rubiconproject.keywords.impl;

import java.util.Random;

import com.rubiconproject.keywords.KeywordService;

public class KeywordProviderService implements KeywordService {
	
	private String[] keywords = {"sports", "travel", "tennis", "recreation", "hiking", "seaside",
	                             	"chess", "banks", "kayaking", "polo"};
	
	@Override
	/*
	 * random implementation 
	 */
	public String resolveKeywords(Object site) {
		Random random = new Random();
		int size = random.nextInt(4);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i != 0)
				builder.append(",");
			
			builder.append(keywords[random.nextInt(keywords.length)]);
		}
		
		return builder.toString();
	}
}
