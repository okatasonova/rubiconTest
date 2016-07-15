package com.rubiconproject.writer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rubiconproject.keywords.KeywordService;
import com.rubiconproject.keywords.impl.KeywordProviderService;
import com.rubiconproject.model.SiteEntry;

/*
 * Custom serializer for SiteEntry with keywordService inside
 */
public class SiteEntrySerializer extends JsonSerializer<SiteEntry>{
	
	private KeywordService keywordService = new KeywordProviderService();
	
	@Override
    public void serialize(SiteEntry value, 
                          JsonGenerator jsonGenerator, 
                          SerializerProvider serializerProvider) 
                          throws IOException, JsonProcessingException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("id", ""+value.getId());
		jsonGenerator.writeStringField("name", value.getName());
		jsonGenerator.writeNumberField("mobile", value.isMobile() ? 1 : 0);
		jsonGenerator.writeStringField("keywords", keywordService.resolveKeywords(value));
		jsonGenerator.writeNumberField("score", value.getScore());
		jsonGenerator.writeEndObject();
    }
}