package com.file.calc;

import java.io.File;
import java.util.concurrent.Callable;

public class FilesCalculatorThread implements FilesCalculator, Callable<ProcessedThreadData>{	
	
	private ProcessedThreadData data = new ProcessedThreadData();
	
	private String directoryPath;	
	
	public FilesCalculatorThread(String directoryPath) {
		super();
		this.directoryPath = directoryPath;
	}
	
	@Override
	public ProcessedThreadData call() throws Exception {
		File file = new File(directoryPath);
		calculateDirectoryContent(file);
		return data;
	}

	@Override
	public void calculateDirectoryContent(File dir) {
		File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				data.populateFoldersMap(file.getName());
				data.getFoldersDir().add(file.getAbsolutePath());
			} else {
				data.populateFilesMap(file.getName());
			}
		}
	}
}
