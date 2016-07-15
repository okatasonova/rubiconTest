package com.rubiconproject;

import java.io.File;

/**
 * @author okatasonova
 * 
 * The launcher of the program. 
 * Provide 2 arguments to make it running:
 * - path to directory with files
 * - path to the output file/name of the output file
 */
public class Launcher {
	
	public static void main( String[] args ) {
		if (ArgumentsCheck.validated(args)) {
			DataProcessingService service = new DataProcessingService(new File(args[0]), new File(args[1]));
			service.processData();
		}
	}
}
