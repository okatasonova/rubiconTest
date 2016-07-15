package com.rubiconproject.reader;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rubiconproject.model.DataSource;
import com.rubiconproject.model.SiteEntry;
import com.rubiconproject.reader.impl.CSVFileReader;

public class CSVFileReaderTest {
	private CSVFileReader target;
	
	@Before
	public void setUp() {
		target = CSVFileReader.getInstance();
	}
	
	@Test
	public void testPositive() {
		// given
		String fileName = "input1small.csv";
		ClassLoader classLoader = getClass().getClassLoader();
		File csvFile = new File(classLoader.getResource(fileName).getFile()); 

		// expected
		SiteEntry entry = new SiteEntry();
		entry.setId(12000);
		entry.setName("example.com/csv1");
		entry.setMobile(true);
		entry.setScore(454.0);
		DataSource expected = new DataSource(fileName, new SiteEntry[]{entry});
		
		DataSource actual = target.readInput(csvFile);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNegative() {
		// given
		String fileName = "input1small.csv";
		ClassLoader classLoader = getClass().getClassLoader();
		File csvFile = new File(classLoader.getResource(fileName).getFile()); 

		// expected
		SiteEntry entry = new SiteEntry();
		entry.setId(12000);
		entry.setName("WRONG_NAME");
		entry.setMobile(true);
		entry.setScore(454.0);
		DataSource expected = new DataSource(fileName, new SiteEntry[]{entry});
		
		DataSource actual = target.readInput(csvFile);
		
		Assert.assertNotEquals(expected, actual);
	}
	
	@After
	public void tearUp() {
		target = null;
	}
}
