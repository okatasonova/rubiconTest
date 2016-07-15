package com.rubiconproject.reader;

import java.io.File;

import com.rubiconproject.model.DataSource;

public interface FileReader {
	
	DataSource readInput(File file);
}
