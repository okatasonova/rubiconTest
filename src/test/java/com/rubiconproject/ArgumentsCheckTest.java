package com.rubiconproject;

import java.net.URL;
import org.junit.Assert;
import org.junit.Test;

public class ArgumentsCheckTest {

	@Test
	public void testPositive() {
		// given
		URL input = this.getClass().getResource("/input");
		//URL output = Paths.get(System.getProperty("user.home"), "output.json");
		String args[] = {input.getPath(), "out.json"};

		boolean actual = ArgumentsCheck.validated(args);

		Assert.assertTrue(actual);
	} 

	@Test
	public void testNoArguments() {
		// given
		String args[] = {};


		boolean actual = ArgumentsCheck.validated(args);

		Assert.assertFalse(actual);
	}

	@Test
	public void testOneArguments() {
		// given
		String args[] = {"out.json"};


		boolean actual = ArgumentsCheck.validated(args);

		Assert.assertFalse(actual);
	}

	@Test
	public void testNotDirectoryArgument() {
		// given
		String args[] = {"out.json", "out.json"};

		boolean actual = ArgumentsCheck.validated(args);

		Assert.assertFalse(actual);
	}

	@Test
	public void testNotFileArgument() {
		// given
		URL input = this.getClass().getResource("/input");
		String args[] = {input.getPath(), input.getPath()};

		boolean actual = ArgumentsCheck.validated(args);

		Assert.assertFalse(actual);
	}
}
