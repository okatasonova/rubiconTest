package com.rubiconproject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rubiconproject.model.DataSource;
import com.rubiconproject.reader.FileReader;
import com.rubiconproject.reader.ReaderFactory;
import com.rubiconproject.writer.JSONFileWriter;

/**
 * @author okatasonova
 * 
 * A service for merging different file resources of data into one holistic collection.
 * The result is written to outputFile, which is declared as argument.
 * Check output file by absolute path or in the root of the project. 
 */
public class DataProcessingService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DataProcessingService.class);

	private File directory;
	private File outputFile;

	public DataProcessingService(File directory, File outputFile) {
		this.directory = directory;
		this.outputFile = outputFile;
	}

	public void processData() {	
		List<DataSource> data = collectData();

		// write result to output file
		JSONFileWriter writer = JSONFileWriter.getInstance();
		writer.writeOutput(outputFile, data);

		LOGGER.info("Data processed to {}", outputFile.getAbsolutePath());
	}

	// collect the data from input directory
	public List<DataSource> collectData() {
		List<DataSource> merged = new ArrayList<DataSource>();

		for (final File fileEntry : directory.listFiles()) {
			if (fileEntry.isFile()) {
				FileReader reader = ReaderFactory.getReader(fileEntry.getName());
				DataSource dataSource = reader.readInput(fileEntry);
				merged.add(dataSource);
			}
		}
		
		return merged;
	}
}
