package com.rubiconproject.writer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rubiconproject.model.DataSource;

/**
 * @author okatasonova
 * 
 * Write list of DataSource objects to given json file
 * Thread safe singleton class
 */
public class JSONFileWriter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JSONFileWriter.class);

	// Private constructor prevents instantiation from other classes
	private JSONFileWriter() { }

	/**
	 * SingletonHolder is loaded on the first execution of JSONFileWriter.getInstance() 
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder { 
		public static final JSONFileWriter instance = new JSONFileWriter();
	}

	public static JSONFileWriter getInstance() {
		return SingletonHolder.instance;
	}
	//

	public boolean writeOutput(File output, List<DataSource> data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter().writeValue(output, data);
		} catch (JsonGenerationException e) {
			LOGGER.error("Error at json generation phase", e);
		} catch (JsonMappingException e) {
			LOGGER.error("Error at json mapping phase", e);
		} catch (IOException e) {
			LOGGER.error("Error at input/output phase", e);
		}
		return true;
	}
}
