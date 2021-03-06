package com.file.calc;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FilesCalculatorTask extends RecursiveTask<ProcessedTaskData>
		implements FilesCalculator {

	private static final long serialVersionUID = 2101509171027567797L;

	private ProcessedThreadData data = new ProcessedThreadData();

	private String directoryPath;

	public FilesCalculatorTask(String directoryPath) {
		super();
		this.directoryPath = directoryPath;
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
				calculateDirectoryContent(file);
			} else {
				data.populateFilesMap(file.getName());
			}
		}
	}

	@Override
	protected ProcessedTaskData compute() {
		List<FilesCalculatorTask> taskList = new LinkedList<>();
		File file = new File(directoryPath);
		return null;
	}

}
