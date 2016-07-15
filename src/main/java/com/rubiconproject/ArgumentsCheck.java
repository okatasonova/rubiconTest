package com.rubiconproject;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author okatasonova
 * 
 * A class to check correctness of required arguments. 
 * Expected 2 arguments:
 * - path to directory with files
 * - path to the output file
 */
public class ArgumentsCheck {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentsCheck.class);

	public static boolean validated(String args[]) {
		if (args.length < 2) {
			LOGGER.info("The program expects two arguments: path to directory with files "
					+ "and path to output file");
			return false;
		}
		
		File directory = new File(args[0]);
		if (!directory.exists()) {
			LOGGER.info("The program expects path to the directory as first argument");
			return false;
		}
		
		File file = new File(args[1]);
		if (file.isDirectory()) {
			LOGGER.info("The program expects path to output file as second argument");
			return false;
		}
		
		return true;
	}
}
