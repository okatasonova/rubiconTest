package com.rubiconproject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.rubiconproject.model.DataSource;
import com.rubiconproject.model.SiteEntry;

public class DataProcessingServiceTest {
	
	private DataProcessingService target;
	
	@Test
	public void testCollectData() {
		// given
		URL input = this.getClass().getResource("/input");
		
		// expected
		SiteEntry entry1 = new SiteEntry();
		entry1.setId(12000);
		entry1.setName("example.com/csv1");
		entry1.setMobile(true);
		entry1.setScore(454.0);
		SiteEntry entry2 = new SiteEntry();
		entry2.setId(12001);
		entry2.setName("example.com/csv2");
		entry2.setMobile(true);
		entry2.setScore(128.0);
		SiteEntry entry3 = new SiteEntry();
		entry3.setId(12002);
		entry3.setName("example.com/csv3");
		entry3.setMobile(false);
		entry3.setScore(522.0);
		DataSource source1 = new DataSource("input1.csv", new SiteEntry[]{entry1, entry2, entry3});
		
		SiteEntry entry4 = new SiteEntry();
		entry4.setId(13000);
		entry4.setName("example.com/json1");
		entry4.setMobile(true);
		entry4.setScore(21.0);
		SiteEntry entry5 = new SiteEntry();
		entry5.setId(13001);
		entry5.setName("example.com/json2");
		entry5.setMobile(false);
		entry5.setScore(97.0);
		SiteEntry entry6 = new SiteEntry();
		entry6.setId(13002);
		entry6.setName("example.com/json3");
		entry6.setMobile(false);
		entry6.setScore(311.0);
		DataSource source2 = new DataSource("input2.json", new SiteEntry[]{entry4, entry5, entry6});
		
		List<DataSource> expected = new ArrayList<DataSource>();
		expected.add(source1);
		expected.add(source2);
		
		target = new DataProcessingService(new File(input.getPath()), new File("output.json"));
		List<DataSource> actual = target.collectData();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testProcessData() {
		// given
		URL input = this.getClass().getResource("/input");
		
		target = new DataProcessingService(new File(input.getPath()), new File("output.json"));
		target.processData();
		
		// have no assertation
	}
}
