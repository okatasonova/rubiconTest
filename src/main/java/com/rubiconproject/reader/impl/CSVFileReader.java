package com.rubiconproject.reader.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.rubiconproject.model.DataSource;
import com.rubiconproject.model.SiteEntry;
import com.rubiconproject.reader.FileReader;


/**
 * @author okatasonova
 *
 * Read csv file to DataSource object with SiteEntry usage
 * Thread safe singleton class
 */
public class CSVFileReader implements FileReader{

	private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileReader.class);
	
	// Private constructor prevents instantiation from other classes
    private CSVFileReader() { }

    /**
    * SingletonHolder is loaded on the first execution of CSVFileReader.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final CSVFileReader instance = new CSVFileReader();
    }

    public static CSVFileReader getInstance() {
            return SingletonHolder.instance;
    }
	//
    
	@Override
	public DataSource readInput(File file) {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(SiteEntry.class).withSkipFirstDataRow(true).withoutHeader();
		
		try {
			MappingIterator<SiteEntry> iterator = mapper.readerFor(SiteEntry.class).with(schema).readValues(file);

			List<SiteEntry> sites = new ArrayList<SiteEntry>();
			while (iterator.hasNext()) {
				SiteEntry entry = iterator.next();
				// TODO: workaround, since withSkipFirstDataRow and withoutHeader properties won't work
				if (entry.getName() != null)
					sites.add(entry);
			}
		
			SiteEntry[] sitesArr = sites.toArray(new SiteEntry[sites.size()]);
			return new DataSource(file.getName(), sitesArr);
		} catch(IOException e) {
			LOGGER.error("Error at csv reading phase", e);
		}
		
		return null;
	}
}
