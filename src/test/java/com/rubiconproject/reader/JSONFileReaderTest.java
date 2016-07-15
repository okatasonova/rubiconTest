package com.rubiconproject.reader;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rubiconproject.model.DataSource;
import com.rubiconproject.model.SiteEntry;
import com.rubiconproject.reader.impl.JSONFileReader;

public class JSONFileReaderTest {
	private JSONFileReader target;

	@Before
	public void setUp() {
		target = JSONFileReader.getInstance();
	}

	@Test
	public void testPositive() {
		// given
		String fileName = "input2small.json";
		ClassLoader classLoader = getClass().getClassLoader();
		File csvFile = new File(classLoader.getResource(fileName).getFile()); 

		// expected
		SiteEntry entry = new SiteEntry();
		entry.setId(13000);
		entry.setName("example.com/json1");
		entry.setMobile(true);
		entry.setScore(21.0);
		DataSource expected = new DataSource(fileName, new SiteEntry[]{entry});

		DataSource actual = target.readInput(csvFile);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testNegative() {
		// given
		String fileName = "input2small.json";
		ClassLoader classLoader = getClass().getClassLoader();
		File csvFile = new File(classLoader.getResource(fileName).getFile()); 

		// expected
		SiteEntry entry = new SiteEntry();
		entry.setId(13000);
		entry.setName("WRONG_NAME");
		entry.setMobile(true);
		entry.setScore(21.0);
		DataSource expected = new DataSource(fileName, new SiteEntry[]{entry});

		DataSource actual = target.readInput(csvFile);

		Assert.assertNotEquals(expected, actual);
	}

	@After
	public void tearUp() {
		target = null;
	}
}
