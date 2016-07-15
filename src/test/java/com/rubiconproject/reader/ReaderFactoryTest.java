package com.rubiconproject.reader;

import org.junit.Assert;
import org.junit.Test;

import com.rubiconproject.reader.impl.CSVFileReader;
import com.rubiconproject.reader.impl.JSONFileReader;

public class ReaderFactoryTest {

	@Test
	public void testJSON() {
		// given
		String filename = "test.JSoN";

		FileReader target = ReaderFactory.getReader(filename);

		Assert.assertTrue(target instanceof JSONFileReader);
	}

	@Test
	public void testCSV() {
		// given
		String filename = "test.csV";

		FileReader target = ReaderFactory.getReader(filename);

		Assert.assertTrue(target instanceof CSVFileReader);
	}

	@Test(expected = RuntimeException.class)
	public void testUnsupported() {
		// given
		String filename = "test.txt";

		FileReader target = ReaderFactory.getReader(filename);
	}
}
