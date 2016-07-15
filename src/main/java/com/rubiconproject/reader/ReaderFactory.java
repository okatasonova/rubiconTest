package com.rubiconproject.reader;

import com.rubiconproject.reader.impl.CSVFileReader;
import com.rubiconproject.reader.impl.JSONFileReader;

/**
 * @author okatasonova
 * A factory to choose corresponding reader depends on file extension.
 * CSV and JSON extensions are supported in the current implementation.
 *
 */
public class ReaderFactory {
	
	public static final String JSON = "json";
	public static final String CSV = "csv";

	public static FileReader getReader(String filename) {
		if (filename.toLowerCase().endsWith(JSON)) {
			return JSONFileReader.getInstance();
		} else if (filename.toLowerCase().endsWith(CSV)) {
			return CSVFileReader.getInstance();
		} else {
			throw new RuntimeException("Unsupported file format: please use json or csv instead");
		}
	}
}
