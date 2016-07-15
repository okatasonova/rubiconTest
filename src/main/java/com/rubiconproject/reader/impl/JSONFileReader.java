package com.rubiconproject.reader.impl;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubiconproject.model.DataSource;
import com.rubiconproject.model.SiteEntry;
import com.rubiconproject.reader.FileReader;

/**
 * @author okatasonova
 * 
 * Read json file to DataSource object with SiteEntry usage.
 * Thread safe singleton class
 */
public class JSONFileReader implements FileReader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONFileReader.class);

	// Private constructor prevents instantiation from other classes
    private JSONFileReader() { }

    /**
    * SingletonHolder is loaded on the first execution of JSONFileReader.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final JSONFileReader instance = new JSONFileReader();
    }

    public static JSONFileReader getInstance() {
            return SingletonHolder.instance;
    }
	//
	
	@Override
	public DataSource readInput(File file) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			SiteEntry[] sites = mapper.readValue(file, SiteEntry[].class);
			return new DataSource(file.getName(), sites);
			
		} catch (JsonGenerationException e) {
			LOGGER.error("Error at json generation phase", e);
		} catch (JsonMappingException e) {
			LOGGER.error("Error at json mapping phase", e);
		} catch (IOException e) {
			LOGGER.error("Error at input/output phase", e);
		}

		return null;
	}
}
